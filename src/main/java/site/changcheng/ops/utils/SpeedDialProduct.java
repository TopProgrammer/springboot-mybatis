package site.changcheng.ops.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

/**
 * Created by uworks on 2017/5/25.
 */
public class SpeedDialProduct {
    private final char[] nineNumber = {'1','2','3','4','5','6','7','8','9'};
    public static ImageCaptcha getLoginImageCaptcha() {

        // 生成随机类
        Random random = new Random();
        int width = 300, height = 300;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 获取图形上下文
        Graphics g = image.getGraphics();
        // 设定背景色
        g.setColor(Color.GRAY);
        g.drawRect(0, 0, width, height);
        g.setColor(Color.white);
        g.fillRect(1, 1, width - 2, height - 2);
        // 设定字体
        g.setFont(new Font("宋体", Font.BOLD, 25));
        // 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(new Color(125, 93, 100));

        Set<Integer> set = new TreeSet<>();
        List list = new ArrayList<Integer>();
        while (set.size()<9){
            Integer s = (int)(Math.random()*10);
            if(s.equals(0)){
                continue;
            }
            if(set.add(s)){
                list.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (set.size()<9){
            Integer s = (int)(Math.random()*10);
            if(s.equals(0)){
                continue;
            }
            if(set.add(s)){
                sb.append(s+"");
            }
        }
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
                // 将认证码显示到图象中
                g.setColor(new Color(255, 0, 0));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
                // g.translate(random.nextInt(3), random.nextInt(3));
                g.drawString(list.get(3*i+j)+"", 23 * i + 6,23 * j+ 26);
            }
        }
        // 图象生效
        g.dispose();
        ImageCaptcha captcha = new ImageCaptcha();
        captcha.captcha = sb.toString();
        captcha.image = image;
        return captcha;
    }
}
