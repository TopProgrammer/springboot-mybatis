package site.changcheng.ops.utils.operation;

public enum StatusCode {
	//系统级别
	SUCCESS(0,"操作成功"),
	SYSTEM_ERROR(1,"系统错误"),
	
	// 200 - 299 用户管理
	  USER_LOGIN_ERROR(200, "您输入的账户名和密码不匹配，请重新输入"),
	  USER_LOGINID_ERROR(201,"您输入的账号尚未注册!"),
	  USER_NOT_EXIST(207,"用户不存在"),
	  USER_CODE_ERROE(205,"验证码错误"),
	  USER_PASSWORD_ERROR(206,"密码错误"),
	  USER_ACCOUNT_PASSWORD_IS_NOT_EMPTY(227,"账号或密码不能为空"),
	  USER_LOGIN_LOCKED(203,"登录密码错误过多，账户已冻结，请三小时之后尝试重新登录或找回密码!"),
	;
	public Integer code;
	public String label;
	
	private StatusCode(Integer code,String label){
		this.code=code;
		this.label=label;
		
	}
	public static String getLabel(int code){
		String result="";
		for(StatusCode status: StatusCode.values()){
			if(status.code==code){
				result=status.label;
			}
		}
		return result;
	}
}
