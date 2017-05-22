package site.changcheng.ops.utils;
import java.awt.image.RenderedImage;
import java.io.Serializable;

/**
*
*@author wangzhicheng@uworks.cc
*
**/
public class ImageCaptcha implements Serializable{

  private static final long serialVersionUID = -5130032017654989818L;
  /**
   * 图片
   */
  public RenderedImage image;
  /**
   * 验证码
   */
  public String captcha;
}
