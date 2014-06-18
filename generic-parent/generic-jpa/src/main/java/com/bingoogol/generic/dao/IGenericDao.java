package com.bingoogol.generic.dao;

import java.io.Serializable;

/**
 * 公共的Dao处理对象，这对象中包含了JPA的所有基本操作和对SQL的操作
 * @author bingoogol
 *
 * @param <T>
 */
public interface IGenericDao<T> {
	/**
	 * 添加对象
	 * @param entity
	 * @return
	 */
	public void add(T entity);
	/**
	 * 更新对象
	 * @param entity
	 */
	public void update(T entity);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(Serializable ... entityids);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(Serializable entityid);
}
