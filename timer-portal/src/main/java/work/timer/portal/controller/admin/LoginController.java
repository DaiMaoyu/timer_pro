package work.timer.portal.controller.admin;


import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @Author DaiMao
 * 个人qq: 12636993
 * @Date 2020/3/14 0014 19:01
 * TODO: (这里用一句话描述这个类的作用)
 */
@Controller
public class LoginController {

    @Autowired
    private Producer captchaProducer;

    @GetMapping("login.do")
    public String toLogin(){
        return "/admin/login";
    }

    @GetMapping("doCaptcha.do")
    public void doCaptcha(HttpServletResponse httpServletResponse){
        String text = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(text);
        try (ServletOutputStream outputStream = httpServletResponse.getOutputStream()){
            ImageIO.write(image,"jpg",outputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
