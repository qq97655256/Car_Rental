package first.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

@Component
public class Emil {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String MAIL_SENDER;

    public void testEmil(String emil,HttpServletRequest request) {
        String str = "0123456789";
        StringBuilder sb = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        String random = sb.toString();
//存入session
        System.out.println(random);
        HttpSession session = request.getSession();
        session.setAttribute("random",random);
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //发件人
        simpleMailMessage.setFrom(MAIL_SENDER);
        //收件人
        simpleMailMessage.setTo(emil);
        //设置主题
        simpleMailMessage.setSubject("凹凸租车");
        //设置内容
        simpleMailMessage.setText("您的登录验证码是:"+random+"该验证码在3分钟内有效！");
        javaMailSender.send(simpleMailMessage);
    }
}
