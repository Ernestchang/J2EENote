package com.bingoogol.generic.dao;

/**
 * 公共的Dao处理对象，这对象中包含了Hibernate的所有基本操作和对SQL的操作
 * @author bingoogol
 *
 * @param <T>
 */
public interface IGenericDao<T> {
	/**
	 * 添加对象
	 * @param t
	 * @return
	 */
	public T add(T t);
	/**
	 * 更新对象
	 * @param t
	 */
	public void update(T t);
	/**
	 * 根据id删除对象
	 * @param id
	 */
	public void delete(int id);
	/**
	 * 根据id加载对象
	 * @param id
	 * @return
	 */
	public T load(int id);
}
