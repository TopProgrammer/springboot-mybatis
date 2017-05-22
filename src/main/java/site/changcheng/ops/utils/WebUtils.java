package site.changcheng.ops.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class WebUtils {
	
	private static Log logger=LogFactory.getLog(WebUtils.class);
	/**
	 * 创建pageVO对象
	 */
	public static PageVo createPageVo(HttpServletRequest request,int recordCount){
		PageVo pageVo=new PageVo();
		int pageNo=0;
		int pageSize=20;
		if(request.getParameter("PAGE_NO_KEY")!=null){
			String s=request.getParameter("PAGE_NO_KEY");
			pageNo=Integer.parseInt(s);
		}
		if(request.getParameter("PAGE_SIZE_KEY")!=null){
			String s=request.getParameter("PAGE_SIZE_KEY");
			pageSize=Integer.parseInt(s);
		}
		pageVo.setPageSize(pageSize);
		pageVo.setCurrentPage(pageNo);
		pageVo.setRecordCount(recordCount);
		
		return pageVo;
	}
	
	  public static PageVo findPageVo(HttpServletRequest request) {
		    try {

		      Object o = request.getParameter("PAGE_NO_KEY");
		      //PAGE_NO_KEY对应的value为空，表示有页数，就不必创建了，
		      if (o == null) {
		        PageVo pageVo = new PageVo();
		        pageVo.setPageSize(10);
		        pageVo.setCurrentPage(1);
		        pageVo.setRecordCount(0);
		        return pageVo;
		      } else if(o instanceof String && !"".equals(o)) {
		     // int recordCount = Integer.parseInt((String) o);
		        //有页数
		        String PAGE_RECORDCOUNT_KEY =
		            request.getParameter("PAGE_RECORDCOUNT_KEY");
		        int recordCount = Integer.parseInt(PAGE_RECORDCOUNT_KEY);
		        return createPageVo(request, recordCount);
		      }
		    } catch (NumberFormatException e) {
		      logger.error("格式化页码异常", e);
		    }
		    return null;
		  }
}
