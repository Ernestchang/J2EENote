package com.wh.base.service.base;

import java.io.Serializable;
import java.util.LinkedHashMap;

import com.wh.base.bean.QueryResult;
/**
 * 实体操作通用接口
 * @author 496312716@qq.com
 * @param <T> 实体类型
 */
public interface DAO<T> {
	/**
	 * 清除一级缓存的数据
	 */
	public void clear();
	/**
	 * 保存实体
	 * @param entity 实体对象
	 */
	public void save(T entity);
	/**
	 * 更新实体
	 * @param entity 实体对象
	 */
	public void update(T entity);
	/**
	 * 删除实体
	 * @param entityids 实体id数组
	 */
	public void delete(Serializable ... entityids);  //JPA规定实体的id属性必须实现序列化接口
	/**
	 * 获取实体
	 * @param entityid 实体标识
	 * @return 实体对象
	 */
	public T find(Serializable entityid);
	/**
	 * 按条件获取总记录数
	 * @param where 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值从1开始
	 * @param queryParams 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值从1开始
	 * @return 总记录数
	 */
	public long getCount(String where, Object[] queryParams);
	/**
	 * 获取实体的总记录数
	 * @return 总记录数
	 */
	public long getCount();
	/**
	 * 按条件分页获取排序记录
	 * @param firstResult 开始索引，如果输入值为-1则获取全部数据
	 * @param maxResult 每页显示的记录数，如果输入值为-1则获取全部数据
	 * @param where 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值从1开始
	 * @param queryParams 条件语句出现的位置参数值
	 * @param orderby 排序，Key为排序属性，Value为asc/desc
	 * @return 记录集
	 */
	public QueryResult<T> getScrollData(int firstResult, int maxResult, String where, Object[] queryParams, LinkedHashMap<String, String> orderby);
	/**
	 * 按条件分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1则获取全部数据
	 * @param maxResult 每页显示的记录数，如果输入值为-1则获取全部数据
	 * @param where 条件语句，不带where关键字，条件语句只能使用位置参数，位置参数的索引值从1开始
	 * @param queryParams 条件语句出现的位置参数值
	 * @return 记录集
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult, String wherejpql, Object[] queryParams);
	/**
	 * 分页获取排序记录
	 * @param firstResult 开始索引，如果输入值为-1则获取全部数据
	 * @param maxResult 每页显示的记录数，如果输入值为-1则获取全部数据
	 * @param orderby 排序，Key为排序属性，Value为asc/desc
	 * @return 记录集
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult, LinkedHashMap<String, String> orderby);
	/**
	 * 分页获取记录
	 * @param firstResult 开始索引，如果输入值为-1则获取全部数据
	 * @param maxResult 每页显示的记录数，如果输入值为-1则获取全部数据
	 * @return 记录集
	 */
	public QueryResult<T> getScrollData(int firstindex, int maxresult);
	/**
	 * 获取所有记录
	 * @return 记录集
	 */
	public QueryResult<T> getScrollData();
}
