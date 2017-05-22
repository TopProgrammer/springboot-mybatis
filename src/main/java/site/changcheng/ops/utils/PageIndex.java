package site.changcheng.ops.utils;

import java.io.Serializable;

public class PageIndex implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int startIndex;
	private int endIndex;

	public PageIndex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PageIndex(int startIndex, int endIndex) {
		super();
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public static PageIndex getPageIndex(int viewPageCount, int currentPage,
			int totalPage) {
		int startPage = currentPage
				- (viewPageCount % 2 == 0 ? viewPageCount / 2 - 1
						: viewPageCount / 2);
		int endPage = currentPage + viewPageCount / 2;
		if(startPage<1){
			startPage=1;
			if(totalPage>=viewPageCount)
				endPage=viewPageCount;
				else endPage=totalPage;
		}
		if(endPage>totalPage){
			endPage=totalPage;
		}if(endPage>totalPage){
			endPage=totalPage;
			if((endPage-viewPageCount)>0)
				startPage=endPage-viewPageCount+1;
			else 
				startPage=1;
			
		}
		return new PageIndex(startPage, endPage);
	}
}
