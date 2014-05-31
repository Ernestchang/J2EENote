package com.bingoogol.algorithmhome.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 分页对象
 * 
 * @author bingoogol@sina.com
 */
public class PagerJson implements Serializable {
	private static final long serialVersionUID = -7778309226851035256L;
	/**
	 * 总记录数
	 */
	private Long total;
	/**
	 * 分页的数据
	 */
	private List<Map<String, Object>> rows;
	/**
	 * 每页显示记录数
	 */
	private Integer maxResult = 5;
	/**
	 * 总页数
	 */
	private Integer totalPage;
	/**
	 * 当前页
	 */
	private Integer currentIndex = 1;
	/**
	 * 要显示页码的第一页
	 */
	private Integer beginIndex;
	/**
	 * 要显示页码的最后一页
	 */
	private Integer endIndex;
	/**
	 * 要显示的页码数量
	 */
	private Integer totalIndex = 7;
	/**
	 * 排序字段名
	 */
	private String sort = null;
	/**
	 * 按什么排序(asc,desc)
	 */
	private String order = "asc";

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
		setTotalPage((int) ((total - 1) / maxResult + 1));
	}

	public List<Map<String, Object>> getRows() {
		return rows;
	}

	public void setRows(List<Map<String, Object>> rows) {
		this.rows = rows;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
		initIndex();
	}

	public Integer getCurrentIndex() {
		return currentIndex;
	}

	public void setCurrentIndex(Integer currentIndex) {
		this.currentIndex = currentIndex;
	}

	public Integer getBeginIndex() {
		return beginIndex;
	}

	public void setStartIndex(Integer beginIndex) {
		this.beginIndex = beginIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getTotalIndex() {
		return totalIndex;
	}

	public void setTotalIndex(Integer totalIndex) {
		this.totalIndex = totalIndex;
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

	public void initIndex() {
		beginIndex = currentIndex - (totalIndex % 2 == 0 ? totalIndex / 2 - 1 : totalIndex / 2);
		endIndex = currentIndex + totalIndex / 2;
		if (beginIndex < 1) {
			beginIndex = 1;
			if (totalPage >= totalIndex) {
				endIndex = totalIndex;
			} else {
				endIndex = totalPage;
			}
		}
		if (endIndex > totalPage) {
			endIndex = totalPage;
			if ((endIndex - totalIndex) > 0) {
				beginIndex = endIndex - totalIndex + 1;
			} else {
				beginIndex = 1;
			}
		}
	}

	@Override
	public String toString() {
		return "PagerJson [total=" + total + ", rows=" + rows + ", maxResult=" + maxResult + ", totalPage=" + totalPage + ", currentIndex=" + currentIndex + ", beginIndex=" + beginIndex + ", endIndex=" + endIndex + ", totalIndex=" + totalIndex + ", sort=" + sort + ", order=" + order + "]";
	}
}
