package com.bingoogol.algorithmhome.dto;

/**
 * 分页参数
 * 
 * @author bingoogol@sina.com
 */
public class Pager implements java.io.Serializable {
	private static final long serialVersionUID = 4273109356359352882L;
	/**
	 * 当前页
	 */
	private Integer page = 1;
	/**
	 * 每页显示记录数
	 */
	private Integer rows = 5;
	/**
	 * 排序字段名
	 */
	private String sort = null;
	/**
	 * 按什么排序(asc,desc)
	 */
	private String order = "asc";
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Pager [page=" + page + ", rows=" + rows + ", sort=" + sort + ", order=" + order + "]";
	}
}
