package cn.itcast.itcaststore.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtils {
    public static void sendMail(String email, String emailMsg) throws MessagingException {
        //1.设置邮件传输协议，服务器等。
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "SMTP");
        props.setProperty("mail.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("2728962230", "wtqsukxrfhutdgcb");
            }
        };
        //2.创建程序和服务器会话对象
        Session session = Session.getInstance(props, auth);
        //3.写邮件内容
        Message message = new MimeMessage(session);
        //设置发送者
        message.setFrom(new InternetAddress("2728962230@qq.com"));
        //设置发送方式与接受者，邮件接收者在调用sendMail()方法时通过参数传递进来
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
        //设置发出的邮件主题
        message.setSubject("测试邮件发送");
        message.setContent(emailMsg, "text/html;charset=utf-8");
        //4.发送邮件
        Transport.send(message);
    }

//    public static void main(String[] args) {
//        for(int i = 0; i < 5; i++){
//            try {
//                MailUtils.sendMail("859316354@qq.com", "测试QQ邮箱给自己发一封邮件");
//            } catch (MessagingException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
