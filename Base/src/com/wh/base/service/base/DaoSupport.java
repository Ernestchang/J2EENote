package com.wh.base.service.base;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wh.base.bean.QueryResult;
import com.wh.base.utils.GenericsUtils;
@Transactional //spring只会对定义在本类的方法应用事务通知(Advice)
public abstract class DaoSupport<T> implements DAO<T> {
	@PersistenceContext
	protected EntityManager em;
	
	@SuppressWarnings("unchecked")
	protected Class<T> entityClass =GenericsUtils.getSuperClassGenricType(getClass());
	
	public void clear(){
		em.clear();
	}
	
	public void save(T entity) {
		em.persist(entity);
	}
	
	public void update(T entity) {
		em.merge(entity);
	}
	
	public void delete(Serializable ... entityids) {
		for(Object entityid : entityids){
			em.remove(em.getReference(entityClass, entityid));
		}
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public T find(Serializable entityid) {
		return em.find(entityClass, entityid);
	}
	
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public long getCount(String where, Object[] queryParams) {
		String whereql = where != null && !"".equals(where.trim())? " where "+ where:"";
		Query query = em.createQuery("select count(" + getCountField(entityClass) + ") from " + getEntityName(entityClass) + " o" + whereql);
		setQueryParameter(query, queryParams);
		return (Long)query.getSingleResult();
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public long getCount() {
		return getCount(null, null);
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String where, Object[] queryParams, LinkedHashMap<String, String> orderby) {
		String whereql = where != null && !"".equals(where.trim())? " where "+ where:"";
		Query query = em.createQuery("select o from " + getEntityName(entityClass) + " o" + whereql + buildOrderby(orderby));
		if(firstindex!=-1 && maxresult!=-1) {
			query.setFirstResult(firstindex).setMaxResults(maxresult);
		}
		setQueryParameter(query, queryParams);
		QueryResult<T> qr = new QueryResult<T>();
		qr.setResultlist(query.getResultList());
		qr.setTotalrecord(getCount(where, queryParams));
		return qr;
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams) {
		return getScrollData(firstindex,maxresult,wherejpql,queryParams,null);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby) {
		return getScrollData(firstindex,maxresult,null,null,orderby);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData(int firstindex, int maxresult) {
		return getScrollData(firstindex,maxresult,null,null,null);
	}
	@Transactional(readOnly=true,propagation=Propagation.NOT_SUPPORTED)
	public QueryResult<T> getScrollData() {
		return getScrollData(-1, -1);
	}
	
	/**
	 * 获取实体的名称
	 * @param <E> 实体类型
	 * @param clazz 实体类
	 * @return 实体名称
	 */
	protected static <E> String getEntityName(Class<E> clazz){
		String entityname = clazz.getSimpleName();
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
	
	/**
	 * 设置查询参数值
	 * @param query 查询对象
	 * @param queryParams 参数值
	 */
	protected static void setQueryParameter(Query query, Object[] params){
		if(params != null && params.length > 0){
			for(int i=0; i<params.length; i++){
				query.setParameter(i+1, params[i]);
			}
		}
	}

	/**
	 * 组装order by语句
	 * @param orderby 排序属性与asc/desc，Key为属性，Value为asc/desc
	 * @return order by语句
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby){
		StringBuilder orderbyql = new StringBuilder();
		if(orderby!=null && orderby.size()>0){
			orderbyql.append(" order by ");
//			for(String key : orderby.keySet()){
//				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
//			}
			for(Map.Entry<String, String> entry : orderby.entrySet()){
				orderbyql.append("o.").append(entry.getKey()).append(" ").append(entry.getValue()).append(",");
			}
			//去掉后最多余的逗号
			orderbyql.deleteCharAt(orderbyql.length()-1);
		}
		return orderbyql.toString();
	}
	
	/**
	 * 获取统计属性,该方法是为了解决hibernate解析联合主键select count(o) from Xxx o语句BUG而增加
	 * hibernate对此jpql解析后的sql为select count(field1,field2,...),显示使用count()统计多个字段是错误的
	 * @param <E> 实体类型
	 * @param clazz 实体对象
	 * @return 统计属性
	 */
	protected static <E> String getCountField(Class<E> clazz){
		String out = "o";
		try {
			PropertyDescriptor[] propertyDescriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();
			for(PropertyDescriptor propertydesc : propertyDescriptors){
				Method method = propertydesc.getReadMethod();
				if(method!=null && method.isAnnotationPresent(EmbeddedId.class)){					
					PropertyDescriptor[] ps = Introspector.getBeanInfo(propertydesc.getPropertyType()).getPropertyDescriptors();
					out = "o."+ propertydesc.getName()+ "." + (!ps[1].getName().equals("class")? ps[1].getName(): ps[0].getName());
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return out;
	}
}
