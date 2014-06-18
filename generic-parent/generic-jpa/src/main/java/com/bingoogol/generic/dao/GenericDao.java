package com.bingoogol.generic.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bingoogol.generic.dto.Pager;
import com.bingoogol.generic.dto.SystemContext;

@SuppressWarnings("unchecked")
public class GenericDao<T> implements IGenericDao<T> {
	@PersistenceContext
	protected EntityManager em;
	/**
	 * 创建一个Class的对象来获取泛型的class
	 */
	private Class<?> clz;

	public Class<?> getClz() {
		if (clz == null) {
			// 获取泛型的Class对象
			clz = ((Class<?>) (((ParameterizedType) (this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]));
		}
		return clz;
	}

	@Override
	public void add(T entity) {
		em.persist(entity);
	}

	@Override
	public void update(T entity) {
		em.merge(entity);
	}

	@Override
	public void delete(Serializable ... entityids) {
		for(Serializable entityid : entityids){
			em.remove(em.getReference(getClz(), entityid));
		}
	}

	@Override
	public T load(Serializable entityid) {
		return (T) em.find(getClz(), entityid);
	}
	
	public List<T> list(String ql, Object[] args) {
		return this.list(ql, args, null);
	}

	public List<T> list(String ql, Object arg) {
		return this.list(ql, new Object[] { arg });
	}

	public List<T> list(String ql) {
		return this.list(ql, null);
	}

	private String initSort(String ql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if (sort != null && !"".equals(sort.trim())) {
			ql += " order by " + sort;
			if (!"desc".equals(order))
				ql += " asc";
			else
				ql += " desc";
		}
		return ql;
	}

	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query, Map<String, Object> alias) {
		if (alias != null) {
			Set<String> keys = alias.keySet();
			for (String key : keys) {
				Object val = alias.get(key);
//				if (val instanceof Collection) {
//					// 查询条件是列表
//					query.setParameterList(key, (Collection) val);
//					query.setp
//				} else {
//					query.setParameter(key, val);
//				}
			}
		}
	}

	private void setParameter(Query query, Object[] args) {
		if (args != null && args.length > 0) {
			int index = 0;
			for (Object arg : args) {
				query.setParameter(index++, arg);
			}
		}
	}

	public List<T> list(String ql, Object[] args, Map<String, Object> alias) {
		ql = initSort(ql);
		Query query = em.createQuery(ql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.getResultList();
	}

	public List<T> listByAlias(String ql, Map<String, Object> alias) {
		return this.list(ql, null, alias);
	}

	public Pager<T> find(String ql, Object[] args) {
		return this.find(ql, args, null);
	}

	public Pager<T> find(String ql, Object arg) {
		return this.find(ql, new Object[] { arg });
	}

	public Pager<T> find(String ql) {
		return this.find(ql, null);
	}

	@SuppressWarnings("rawtypes")
	private void setPagers(Query query, Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		if (pageOffset == null || pageOffset < 0)
			pageOffset = 0;
		if (pageSize == null || pageSize < 0)
			pageSize = 15;
		pages.setOffset(pageOffset);
		pages.setSize(pageSize);
		query.setFirstResult(pageOffset).setMaxResults(pageSize);
	}

	private String getCountJpql(String ql, boolean isJpql) {
		String e = ql.substring(ql.indexOf("from"));
		String c = "select count(*) " + e;
		if (isJpql)
			c = c.replaceAll("fetch", "");
		return c;
	}

	public Pager<T> find(String ql, Object[] args, Map<String, Object> alias) {
		ql = initSort(ql);
		String cq = getCountJpql(ql, true);
		Query cquery = em.createQuery(cq);
		Query query = em.createQuery(ql);
		// 设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		// 设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		Pager<T> pages = new Pager<T>();
		setPagers(query, pages);
		List<T> datas = query.getResultList();
		pages.setRows(datas);
		long total = (Long) cquery.getSingleResult();
		pages.setTotal(total);
		return pages;
	}

	public Pager<T> findByAlias(String ql, Map<String, Object> alias) {
		return this.find(ql, null, alias);
	}

	public Object queryObject(String ql, Object[] args) {
		return this.queryObject(ql, args, null);
	}

	public Object queryObject(String ql, Object arg) {
		return this.queryObject(ql, new Object[] { arg });
	}

	public Object queryObject(String ql) {
		return this.queryObject(ql, null);
	}

	public void updateByJpql(String ql, Object[] args) {
		Query query = em.createQuery(ql);
		setParameter(query, args);
		query.executeUpdate();
	}

	public void updateByJpql(String ql, Object arg) {
		this.updateByJpql(ql, new Object[] { arg });
	}

	public void updateByJpql(String hql) {
		this.updateByJpql(hql, null);
	}

	public <N extends Object> List<N> listBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, args, null, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(String sql, Object arg, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, new Object[] { arg }, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		Query sq = em.createNativeQuery(sql, clz);
		 
		setAliasParameter(sq, alias);
		setParameter(sq, args);
		return sq.getResultList();
	}

	public <N extends Object> List<N> listByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		return this.listBySql(sql, null, alias, clz, hasEntity);
	}

	public <N extends Object> Pager<N> findBySql(String sql, Object[] args, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, args, null, clz, hasEntity);
	}

	public <N extends Object> Pager<N> findBySql(String sql, Object arg, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, new Object[] { arg }, clz, hasEntity);
	}

	public <N extends Object> Pager<N> findBySql(String sql, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, clz, hasEntity);
	}

	public <N extends Object> Pager<N> findBySql(String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(sql);
		String cq = getCountJpql(sql, false);
		Query sq = em.createNativeQuery(sql);
		Query cquery = em.createNativeQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		Pager<N> pages = new Pager<N>();
		setPagers(sq, pages);
//		if (hasEntity) {
//			sq.addEntity(clz);
//		} else {
//			sq.setResultTransformer(Transformers.aliasToBean(clz));
//		}
		List<N> datas = sq.getResultList();
		pages.setRows(datas);
		long total = ((BigInteger) cquery.getSingleResult()).longValue();
		pages.setTotal(total);
		return pages;
	}

	public <N extends Object> Pager<N> findByAliasSql(String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		return this.findBySql(sql, null, alias, clz, hasEntity);
	}

	public Object queryObject(String ql, Object[] args, Map<String, Object> alias) {
		Query query = em.createQuery(ql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.getSingleResult();
	}

	public Object queryObjectByAlias(String ql, Map<String, Object> alias) {
		return this.queryObject(ql, null, alias);
	}
}
