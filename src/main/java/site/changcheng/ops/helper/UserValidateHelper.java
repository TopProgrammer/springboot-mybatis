package site.changcheng.ops.helper;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import site.changcheng.ops.utils.operation.StatusCode;


public class UserValidateHelper <T>{
	private static Logger logger=LoggerFactory.getLogger(UserValidateHelper.class);
	
	/**
	 * 验证登录
	 */
	/**
	   * 验证用户登录参数
	   * 
	   * @param username
	   * @param password
	   * @return
	   */
	  public static StatusCode validateLoginParam(String username, String password) {
	    if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
	      return StatusCode.USER_ACCOUNT_PASSWORD_IS_NOT_EMPTY;
	    }
	    if (username.length() < 2) {
	      return StatusCode.USER_NOT_EXIST;
	    }
	    if (password.length() < 2) {
	      return StatusCode.USER_PASSWORD_ERROR;
	    }
	    return null;
	  }

	  /**
	   * 验证登录用户数据
	   * 
	   * @param user
	   * @return
	   */
	  public static <T> StatusCode  validateLoginUser(T user) {
	    if (user == null) {
	      return StatusCode.USER_NOT_EXIST;
	    }
//	    Integer userId = user.getUserId();
//	    if (getLoginTypeLabel(userId) != null) {
//	      return StatusCode.USER_LOGINID_ERROR;
//	    }
//	    if (userId <= -400) {
//	      return StatusCode.USER_PASSWORD_ERROR;
//	    }
//	    if (-99 == userId) {
//	      return StatusCode.USER_LOGIN_LOCKED;
//	    }
	    return null;
	  }

	  /**
	   * 获取登录type的lable
	   * 
	   * @param userId
	   * @return
	   */
	  private static String getLoginTypeLabel(int userId) {
	    if (userId == -1) {
	      return "邮箱";
	    }
	    if (userId == -2) {
	      return "手机";
	    }
	    if (userId == -3) {
	      return "昵称";
	    }
	    return null;
	  }
}
