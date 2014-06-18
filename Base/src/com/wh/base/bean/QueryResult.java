package com.wh.base.bean;

import java.util.List;
/**
 * 查询结果
 * @author 496312716@qq.com
 * @param <T> 实体类型
 */
public class QueryResult<T> {
	/* 记录集 */
	private List<T> resultlist;
	/* 总记录数 */
	private long totalrecord;
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public long getTotalrecord() {
		return totalrecord;
	}
	public void setTotalrecord(long totalrecord) {
		this.totalrecord = totalrecord;
	}
}
