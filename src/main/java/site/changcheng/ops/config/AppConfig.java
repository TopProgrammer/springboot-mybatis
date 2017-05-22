package site.changcheng.ops.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <pre>
 * 与当前应用相关的配置信息。说明：1、ConfigurationProperties中prefix，为application.yml文件中app定义的值
 * 
 * <pre>
 * @author wangzhicheng@uworks.cc
 */
@ConfigurationProperties(prefix = "app")
@Component
public class AppConfig {
  /**
   * 应用名称
   */
  private String appName;
  /**
   * 是否允许跨域
   */
  private Boolean allowCrossDomainAccess;
  /**
   * 是否允许生成API文档
   */
  private Boolean allowGenerateApi;

  /**
   * 订单导出路径
   */
  private String orderPath;

  /**
   * 售后短信模板-提醒天数。
   */
  private int afterSaleRemindDays;

  /**
   * 订单模板路径
   */
  private String templateOrderPath;
  /**
   * 客服电话
   */
  private String customerServicesMobile;

  public String getAppName() {
    return appName;
  }

  public void setAppName(String appName) {
    this.appName = appName;
  }

  public Boolean getAllowCrossDomainAccess() {
    return allowCrossDomainAccess;
  }

  public void setAllowCrossDomainAccess(Boolean allowCrossDomainAccess) {
    this.allowCrossDomainAccess = allowCrossDomainAccess;
  }

  public Boolean getAllowGenerateApi() {
    return allowGenerateApi;
  }

  public void setAllowGenerateApi(Boolean allowGenerateApi) {
    this.allowGenerateApi = allowGenerateApi;
  }

  public String getOrderPath() {
    return orderPath;
  }

  public void setOrderPath(String orderPath) {
    this.orderPath = orderPath;
  }

  public String getTemplateOrderPath() {
    return templateOrderPath;
  }

  public void setTemplateOrderPath(String templateOrderPath) {
    this.templateOrderPath = templateOrderPath;
  }

  public int getAfterSaleRemindDays() {
    return afterSaleRemindDays;
  }

  public void setAfterSaleRemindDays(int afterSaleRemindDays) {
    this.afterSaleRemindDays = afterSaleRemindDays;
  }

  public String getCustomerServicesMobile() {
    return customerServicesMobile;
  }

  public void setCustomerServicesMobile(String customerServicesMobile) {
    this.customerServicesMobile = customerServicesMobile;
  }

}
