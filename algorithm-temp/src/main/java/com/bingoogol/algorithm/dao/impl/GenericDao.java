package com.bingoogol.algorithm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.bingoogol.algorithm.dto.Pager;
import com.bingoogol.algorithm.dto.PagerJson;

@SuppressWarnings("unchecked")
public class GenericDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
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

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(T t) {
		getSession().save(t);
	}

	public void update(T t) {
		getSession().update(t);
	}

	public void delete(int id) {
		getSession().delete(this.load(id));
	}

	public T load(int id) {
		return (T) getSession().load(getClz(), id);
	}

	public List<T> list(Pager pager, String hql, Object[] args) {
		return this.list(pager, hql, args, null);
	}

	public List<T> list(Pager pager, String hql, Object arg) {
		return this.list(pager, hql, new Object[] { arg });
	}

	public List<T> list(Pager pager, String hql) {
		return this.list(pager, hql, null);
	}

	private String initSort(Pager pager, String hql) {
		if(pager != null) {
			String order = pager.getOrder();
			String sort = pager.getSort();
			if (sort != null && !"".equals(sort.trim())) {
				hql += " order by " + sort;
				if (!"desc".equals(order)) {
					hql += " asc";
				} else {
					hql += " desc";
				}
			}
		}
		return hql;
	}

	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query, Map<String, Object> alias) {
		if (alias != null) {
			Set<String> keys = alias.keySet();
			for (String key : keys) {
				Object val = alias.get(key);
				if (val instanceof Collection) {
					// 查询条件是列表
					query.setParameterList(key, (Collection) val);
				} else {
					query.setParameter(key, val);
				}
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

	public List<T> list(Pager pager, String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(pager, hql);
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.list();
	}

	public List<T> listByAlias(Pager pager, String hql, Map<String, Object> alias) {
		return this.list(pager, hql, null, alias);
	}

	public PagerJson<T> find(Pager pager, String hql, Object[] args) {
		return this.find(pager, hql, args, null);
	}

	public PagerJson<T> find(Pager pager, String hql, Object arg) {
		return this.find(pager, hql, new Object[] { arg });
	}

	public PagerJson<T> find(Pager pager, String hql) {
		return this.find(pager, hql, null);
	}

	@SuppressWarnings("rawtypes")
	private void setPagers(Pager pager,Query query, PagerJson pagerJson) {
		Integer maxResult = pager.getRows();
		Integer firstResult = (pager.getPage() - 1) * maxResult;
		if (firstResult == null || firstResult < 0) {
			firstResult = 0;
		}
		if (maxResult == null || maxResult < 0) {
			maxResult = 10;
			pagerJson.setMaxResult(maxResult);
		}
		pagerJson.setCurrentIndex(pager.getPage());
		query.setFirstResult(firstResult).setMaxResults(maxResult);
	}

	private String getCountHql(String hql, boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*) " + e;
		if (isHql)
			c = c.replaceAll("fetch", "");
		return c;
	}

	public PagerJson<T> find(Pager pager, String hql, Object[] args, Map<String, Object> alias) {
		hql = initSort(pager, hql);
		String cq = getCountHql(hql, true);
		Query cquery = getSession().createQuery(cq);
		Query query = getSession().createQuery(hql);
		// 设置别名参数
		setAliasParameter(query, alias);
		setAliasParameter(cquery, alias);
		// 设置参数
		setParameter(query, args);
		setParameter(cquery, args);
		PagerJson<T> pagerJson = new PagerJson<T>();
		setPagers(pager, query, pagerJson);
		List<T> datas = query.list();
		pagerJson.setRows(datas);
		pagerJson.setTotal((Long) cquery.uniqueResult());
		System.out.println(pagerJson.toString());
		return pagerJson;
	}
	
	public PagerJson<T> findByAlias(Pager pager, String hql, Map<String, Object> alias) {
		return this.find(pager, hql, null, alias);
	}

	public Object queryObject(String hql, Object[] args) {
		return this.queryObject(hql, args, null);
	}

	public Object queryObject(String hql, Object arg) {
		return this.queryObject(hql, new Object[] { arg });
	}

	public Object queryObject(String hql) {
		return this.queryObject(hql, null);
	}

	public void updateByHql(String hql, Object[] args) {
		Query query = getSession().createQuery(hql);
		setParameter(query, args);
		query.executeUpdate();
	}

	public void updateByHql(String hql, Object arg) {
		this.updateByHql(hql, new Object[] { arg });
	}

	public void updateByHql(String hql) {
		this.updateByHql(hql, null);
	}
	
	public <N extends Object> List<N> listBySql(Pager pager, String sql, Object[] args, Class<?> clz, boolean hasEntity) {
		return this.listBySql(pager, sql, args, null, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(Pager pager, String sql, Object arg, Class<?> clz, boolean hasEntity) {
		return this.listBySql(pager, sql, new Object[] { arg }, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(Pager pager, String sql, Class<?> clz, boolean hasEntity) {
		return this.listBySql(pager, sql, null, clz, hasEntity);
	}

	public <N extends Object> List<N> listBySql(Pager pager, String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(pager, sql);
		SQLQuery sq = getSession().createSQLQuery(sql);
		setAliasParameter(sq, alias);
		setParameter(sq, args);
		if (hasEntity) {
			sq.addEntity(clz);
		} else
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		return sq.list();
	}

	public <N extends Object> List<N> listByAliasSql(Pager pager, String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		return this.listBySql(pager, sql, null, alias, clz, hasEntity);
	}

	public <N extends Object> PagerJson<N> findBySql(Pager pager, String sql, Object[] args, Class<?> clz, boolean hasEntity) {
		return this.findBySql(pager, sql, args, null, clz, hasEntity);
	}

	public <N extends Object> PagerJson<N> findBySql(Pager pager, String sql, Object arg, Class<?> clz, boolean hasEntity) {
		return this.findBySql(pager, sql, new Object[] { arg }, clz, hasEntity);
	}

	public <N extends Object> PagerJson<N> findBySql(Pager pager, String sql, Class<?> clz, boolean hasEntity) {
		return this.findBySql(pager, sql, null, clz, hasEntity);
	}

	public <N extends Object> PagerJson<N> findBySql(Pager pager, String sql, Object[] args, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		sql = initSort(pager, sql);
		String cq = getCountHql(sql, false);
		SQLQuery sq = getSession().createSQLQuery(sql);
		SQLQuery cquery = getSession().createSQLQuery(cq);
		setAliasParameter(sq, alias);
		setAliasParameter(cquery, alias);
		setParameter(sq, args);
		setParameter(cquery, args);
		PagerJson<N> pagerJson = new PagerJson<N>();
		setPagers(pager, sq, pagerJson);
		if (hasEntity) {
			sq.addEntity(clz);
		} else {
			sq.setResultTransformer(Transformers.aliasToBean(clz));
		}
		List<N> datas = sq.list();
		pagerJson.setRows(datas);
		pagerJson.setTotal((Long) cquery.uniqueResult());
		return pagerJson;
	}

	public <N extends Object> PagerJson<N> findByAliasSql(Pager pager, String sql, Map<String, Object> alias, Class<?> clz, boolean hasEntity) {
		return this.findBySql(pager, sql, null, alias, clz, hasEntity);
	}

	public Object queryObject(String hql, Object[] args, Map<String, Object> alias) {
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, args);
		return query.uniqueResult();
	}

	public Object queryObjectByAlias(String hql, Map<String, Object> alias) {
		return this.queryObject(hql, null, alias);
	}
}
