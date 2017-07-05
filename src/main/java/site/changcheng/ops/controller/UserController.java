package site.changcheng.ops.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import site.changcheng.ops.entity.UserInfo;
import site.changcheng.ops.helper.UserValidateHelper;
import site.changcheng.ops.service.UserInfoService;

import site.changcheng.ops.utils.Constants;
import site.changcheng.ops.utils.ImageCaptcha;
import site.changcheng.ops.utils.OperationResult;
import site.changcheng.ops.utils.SpeedDialProduct;


import site.changcheng.ops.utils.operation.StatusCode;

/**
 * 活动管理Banner图
 * 
 * @author wangzhicheng@uworks.cc
 */
@Api(value = "User 用户接口", produces = "application/json",description ="用户相关操作接口")
@RestController
@RequestMapping("user")
public class UserController {
  
  @Resource
  private UserInfoService userInfoService;
  
  private Logger logger=LoggerFactory.getLogger("UserController");
  
  /**
   * <pre>
   * 添加用户
   * 请求方式：POST
   * 请求路径：/user/addUser
   * 请求参数:user 实体
   * 返回参数：
   * </pre>
   * @param user
   * @return
   */
  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public UserInfo addUser(@RequestBody UserInfo user){
    userInfoService.add(user);
    
    return user;
  }
  
  /**
   * <pre>
   * 登陆-请求验证码
   * 请求方式：GET
   * 请求路径：/user/getLoginCode
   * 请求参数：
   * 返回数据：
   *                  图片
   * </pre>
   * 
   * @param request
   * @param response
   * @return String
   */
  @RequestMapping(value = "/getLoginCode", method = RequestMethod.GET)
  @ResponseBody
  public String getImageCode(HttpServletRequest request,
      HttpServletResponse response){
    logger.info("开始发送验证码!");
    response.setHeader("Pragma", "No-cache");
    response.setHeader("Cache-Control", "no-cache");
    response.setDateHeader("Expires", 0);
    response.setContentType("image/jpeg");
    // 获得图片以及验证码,
    ImageCaptcha imageCaptcha = SpeedDialProduct.getLoginImageCaptcha();
    // 将其保存到缓存中去
    request.getSession().removeAttribute(Constants.WEB_LOGIN_IMAGE_CODE);
    request.getSession().setAttribute(Constants.WEB_LOGIN_IMAGE_CODE,
        imageCaptcha.captcha);
    logger.info("==================="+request.getSession().getAttribute(Constants.WEB_LOGIN_IMAGE_CODE)+"===================");
    // 输出图象到页面
    try {
      ImageIO.write(imageCaptcha.image, "JPEG", response.getOutputStream());
      response.flushBuffer();
    } catch (IOException e) {
      
      e.printStackTrace();
    }
    return "200";
  }
  
  /**
   * <pre>
   * 用户登录
   * 请求方式:POST，请求路径:/user/login
   * 请求参数：
   *          username     用户名(手机号or邮箱or昵称) 必填
   *          password       密码 必填
   *          code              验证码  必填
   * 返回数据：
   *          SUCCESS:
   *          userId  用户主键
   *          FAIL:
   *          201:手机号不存在
   *          202:密码错误(密码错误)
   *          228:用户被锁定
   *          
   * 用户登陆的逻辑
   * 1.校验验证码
   * 2.获取登录用户的ip，浏览器类型和操作系统类型
   * 3.校验登录参数
   * 4.登录校验
   * 登陆之后的一些列操作了uoji
   * 5.重置用户的登录锁定信息
   * 6.将用户信息保存到缓存当中
   * </pre>
   * 
   * @param
   * @param password
   * @param request
   * @return
   * @throws Exception
   */
   @ApiOperation(value = "登录接口", notes = "保存成功返回200代码，没有数据内容返回", httpMethod =
   "POST", produces = "application/json")
  @RequestMapping(value = "/login", method = { RequestMethod.POST })
  @ResponseBody
  public String login(@RequestParam(value = "id", required = true) String id,
      @RequestParam(value = "password", required = true) String password,
      @RequestParam(value = "code", required = true) String code,
      HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    StatusCode statusCode = UserValidateHelper.validateLoginParam(id,
        password);
    
    
    // 校验验证码
    HttpSession session = request.getSession(false);
    if (session == null) {
      return OperationResult.fail("验证码处理问题", 21);
    }
    String captchaCache = (String) session
        .getAttribute(Constants.WEB_LOGIN_IMAGE_CODE);
    if (captchaCache == null) {
      return OperationResult.fail("验证码处理问题", 22);

    }
//    String checkCode=request.getParameter(Constants.WEB_LOGIN_IMAGE_CODE);
//    if(!checkCode.equals(captchaCache)){
//      return OperationResult.fail("验证码处理问题", 23);
//    }

    if (!(code.trim()).equalsIgnoreCase(captchaCache)) {
      return OperationResult.fail(StatusCode.USER_CODE_ERROE);
    }
    // 获取登录用户的ip，浏览器类型和操作系统类型

    Map<String, Object> map = new HashMap<String,Object>();
//    Map<String, Object> map = userService.login(id, password);

    UserInfo user= (UserInfo) map.get("user");
    
    if (user == null) {
      session.removeAttribute(Constants.WEB_LOGIN_IMAGE_CODE);
      return OperationResult.success(map);
      
    }
    request.getSession().setAttribute("user",user);
    Map<String, Object> returnData = new HashMap<String, Object>();
    returnData.put("userId", user.getId());
    session.removeAttribute(Constants.WEB_LOGIN_IMAGE_CODE);
    return OperationResult.success(returnData);
  }

   
  /**
   * 获取所有用户
   * @return
   */
  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  public List<UserInfo> getAllUser(){
    List<UserInfo> list=userInfoService.getAll();
    
    return list;
  }
  
  @RequestMapping(value = "/deleteActivity", method = RequestMethod.POST)
  public UserInfo deleteActivity(@RequestBody UserInfo user){
     
    
    return user;
  }
}
