package com.bingoogol.generic.dto;

import java.util.List;

/**
 * 分页对象
 * 
 * @author bingoogol
 * 
 * @param <T>
 */
public class Pager<T> {
	/**
	 * 分页的大小
	 */
	private Integer size;
	/**
	 * 分页的起始页
	 */
	private Integer offset;
	/**
	 * 总记录数
	 */
	private Long total;
	/**
	 * 分页的数据
	 */
	private List<T> rows;

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}
}
