package site.changcheng.ops.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

import site.changcheng.ops.utils.operation.StatusCode;

public class OperationResult {
	private static List<String> pagerFields=null;
	
	static {
		pagerFields=new ArrayList<String>();
		pagerFields.add("currentPage");
		pagerFields.add("pageSize");
		pagerFields.add("totalPage");
		pagerFields.add("recordCount");
	}
	
	private static SerializeConfig serializeConfig=new SerializeConfig();
	/**
	 * 操作结果，{@link RESULT#SUCCESS}或{@link RESULT#FAIL}
	 */
	public String result;
	public String msg="";
	public Object data;
	/**
	 * 错误吗,如果result为fail则根据错误码检测是什么原因
	 */
	public int code;
	
	public long currentPage;
	public long pageSize;
	public long totalPage;
	public long recordCount;
	
	public String token;
	public Long expireDate;
	public OperationResult(){
		
	}
	
	private OperationResult(RESULT result,String msg,Object data,int code){
		this.result=result.name();
		this.msg=msg;
		this.code=code;
		this.data=data;
		//设置登陆token,用来避免客户端无法获取session登陆状态的情况
		HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		this.token="2333333333232323";
				//UserCacheService.getCacheKey(request);
		this.expireDate=//增加时区偏移量
				System.currentTimeMillis()+TimeZone.getTimeZone("GMT+8").getRawOffset()+60*30*1;
	}
	
	/**
	 * 简单的告知客户端操作成功
	 * @author 王志成
	 *
	 */
	public static String success(){
		SimplePropertyPreFilter filter=new SimplePropertyPreFilter("result","code");
		return JSON.toJSONString(new OperationResult(RESULT.SUCCESS,null,null,StatusCode.SUCCESS.code),filter);
	}
	/**
	 * 返回简单的类型（无级联，嵌套等关系）的数据到客户端，复杂数据请使用
	 * @{link OpeartionResult#success(object,simplePropertyPreFilter)}
	 * @param data
	 * @return
	 */
	public static String success(Object data){
		return new OperationResult(RESULT.SUCCESS,null,data,StatusCode.SUCCESS.code).toJSONString();
	}
	public static String success(Object data,PageVo<?> pager){
		OperationResult result=new OperationResult(RESULT.SUCCESS,null,data,StatusCode.SUCCESS.code);
		if(pager != null){
			result.currentPage=pager.getCurrentPage();
			result.pageSize=pager.getPageSize();
			result.recordCount=pager.getRecordCount();
		}
		return result.toJSONString();
		
	}
	/**
	 * 系统操作失败，并补充失败原因
	 * @return
	 */
	public static String fail(String msg){
		return fail(msg,StatusCode.SYSTEM_ERROR.code);
	}
	/**
	 * 操作失败，并补充原因
	 * @param msg
	 * @param code
	 * @return
	 */
	public static String fail(String msg, Integer code) {
		// TODO Auto-generated method stub
		SimplePropertyPreFilter filter=new SimplePropertyPreFilter("result","msg","code");
		return JSON.toJSONString(new OperationResult(RESULT.FAIL,msg,null,code),filter);
	}

	public static String fail(StatusCode statusCode){
		SimplePropertyPreFilter filter=new SimplePropertyPreFilter("result","msg","code");
		return JSON.toJSONString(new OperationResult(RESULT.FAIL,statusCode.label,null,statusCode.code),filter);
	}
	
	/**
	 * 如果page，pageSize等分页信息都为0，则不返回这些数据的json 
	 * @return
	 */
	private String toJSONString() {
		// TODO Auto-generated method stub
		if(currentPage==0&&pageSize==0&&totalPage==0&&recordCount==0){
			PropertyPreFilter filter=new PropertyPreFilter(){
			public boolean apply(JSONSerializer serializer,Object object,String name){
				if(pagerFields.contains(name)){
					return false;
				}
				return true;
			}
			};
			return JSON.toJSONString(this,serializeConfig,filter);
		}else{
			calculateTotalPage();
			return JSON.toJSONString(this);
		}
	}


	private void calculateTotalPage() {
		// TODO Auto-generated method stub
		if(totalPage!=0||pageSize==0){
			return ;
		}
		totalPage=(recordCount-1)/pageSize+1;
	}


	public enum RESULT{
		SUCCESS,FAIL;
	}
}
