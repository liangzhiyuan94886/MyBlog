package com.blog.liang.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.File;
import java.io.UnsupportedEncodingException;

public class SendEmail {
    public static void main(String[] args) throws EmailException {
         sendEmail("这是一封测试邮件","这是自动发出的邮件...(〃＞目＜)",null,null);
    }
    private static String user = "liangzhiyuan.0407@foxmail.com";
    private static String passwd = "zcefghpjoanfbecb";//授权码
    private static String to = "445459630@qq.com";
    private static String host = "smtp.qq.com";
        public static void sendEmail(String title, String content, String[] tos, String[] ccs) throws EmailException {
            SimpleEmail mail = new SimpleEmail();
            // 设置邮箱服务器信息
            mail.setHostName(host);
            // 设置密码验证器passwd为授权码
            mail.setAuthentication(user, passwd);
            // 设置邮件发送者
            mail.setFrom(user);
            // 设置邮件编码
            mail.setCharset("UTF-8");
            // 设置邮件主题
            mail.setSubject(title);
            //SSL方式
            mail.setSSLOnConnect(true);
            // 设置邮件内容
//             mail.setMsg("你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗你是猪吗");
            // 设置邮件接收者
             mail.addTo(to);
             //多个接收者
//            mail.addTo(tos);
//           // 抄送
//            mail.addCc(ccs);
            // 发送邮件
            MimeMultipart multipartMap = new MimeMultipart();
            //邮件正文
            MimeBodyPart contentPart = new MimeBodyPart();
            try {
                //邮件附件
                MimeBodyPart image = new MimeBodyPart();
                File file = new File("E:\\tencent\\image\\mme.jpg");
                String fileName = MimeUtility.encodeWord(file.getName());
                FileDataSource source = new FileDataSource(file);
                //附件
                image.setDataHandler(new DataHandler(source));
                image.setFileName(MimeUtility.encodeWord(file.getName()));
                multipartMap.addBodyPart(image);
                //正文图片
                contentPart.setDataHandler(new DataHandler(source));
                contentPart.setContentID(fileName);
                //文字
                contentPart.setContent(content+"<br/><img src='cid:"+fileName+"'>","text/html;charset=utf-8");
                multipartMap.addBodyPart(contentPart);
                mail.setContent(multipartMap);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            mail.send();
            System.out.println("mail send success!");
        }
}
