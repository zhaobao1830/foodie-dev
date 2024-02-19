package com.zb.utils;

import java.util.List;

/**
 *
 * @Description: 用来返回分页Grid的数据格式
 */
public class PagedGridResult<T> {
	
	private long current;	// 当前页
	private long pages;		// 总页数
	private long total;		// 总记录数
	private List<?> rows;	// 每页查询的结果集

	public long getCurrent() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}

	public long getPages() {
		return pages;
	}

	public void setPages(long pages) {
		this.pages = pages;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public PagedGridResult() {
	}

	public PagedGridResult(long current, long pages, long total, List<?> rows) {
		this.current = current;
		this.pages = pages;
		this.total = total;
		this.rows = rows;
	}
}
