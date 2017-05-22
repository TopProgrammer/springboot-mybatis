package site.changcheng.ops.utils;

import java.io.Serializable;
import java.util.List;

public class PageVo<E> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static <T> PageVo<T> create(int currentPage){
		PageVo<T> page=new PageVo<T>();
		page.setCurrentPage(currentPage<1?1:currentPage);
		return page;
	}
	
	private static int DEFAULT_PAGE_SIZE = 10;// 默认页面记录总数
	private int recordCount;// 总记录数
	private int pageSize = DEFAULT_PAGE_SIZE;// 页面记录总素
	private int pageCount;// 总页数
	private int currentPage = 1;// 当前页吗
	private List<E> voList;// 数据记录List
	private PageIndex pageIndex;
	private int pageCode = 5;
	private String orderBy;// 拍序值
	private int ascORdesc;// 升序排序0，降序为1；

	public PageVo() {

	}

	public PageIndex getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(PageIndex pageIndex) {
		this.pageIndex = pageIndex;
	}

	public PageVo(int currentPage, int pageSize) {
		this.setCurrentPage(currentPage);
		this.setPageSize(pageSize);
		this.setRecordCount(-1);
		this.setPageCount(-1);
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public void rePageCount(){
		if(pageSize*(currentPage-1)>recordCount)
			setCurrentPage((int)Math.ceil((double)recordCount/(double)pageSize));
		if(pageSize==0)
			setPageSize(DEFAULT_PAGE_SIZE);
		setPageCount((int) Math.ceil((double)recordCount/(double)pageSize));
	}
	
	public int getPageSize() {
		return pageSize < 1 ? DEFAULT_PAGE_SIZE : pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	/**
	 * 设置所需的页码
	 * 
	 * @param pageCount
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<E> getVoList() {
		return voList;
	}

	public void setVoList(List<E> voList) {
		this.voList = voList;
	}

	public int getPageCode() {
		return pageCode;
	}

	public void setPageCode(int pageCode) {
		this.pageCode = pageCode;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public int getAscORdesc() {
		return ascORdesc;
	}

	public void setAscORdesc(int ascORdesc) {
		this.ascORdesc = ascORdesc;
	}
}
