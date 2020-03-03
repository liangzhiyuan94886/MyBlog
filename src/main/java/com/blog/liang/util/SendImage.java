//package com.blog.liang.util;
//
///**
// * Created by liangliang on 2020/3/3 12:21
// */
//public class SendImage {
//    public static void main(String[] args) throws Exception {
//
//        Properties prop = new Properties();
//        //此处使用163邮箱
//        prop.setProperty("mail.smtp.host", "smtp.163.com");
//        prop.setProperty("mail.transport.protocol", "smtp");
//        prop.setProperty("mail.smtp.auth", "true");
//        prop.setProperty("mail.smtp.port", "25");
//        // 使用JavaMail发送邮件的5个步骤
//        // 1、创建session
//        Session session = Session.getInstance(prop);
//        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
//        session.setDebug(true);
//        // 2、通过session得到transport对象
//        Transport ts = session.getTransport();
//        // 3、连上邮件服务器
//        ts.connect("smtp.163.com", "18720160221@163.com", "zbh080931");
//        // 4、创建邮件
//        Message message = createMixedMail(session);
//        // 5、发送邮件
//        ts.sendMessage(message, message.getAllRecipients());
//        ts.close();
//    }
//
//    /**
//     * @Method: createMixedMail
//     * @Description: 生成一封带附件和带图片的邮件
//     * @Anthor:孤傲苍狼
//     *
//     * @param session
//     * @return
//     * @throws Exception
//     */
//    public static MimeMessage createMixedMail(Session session) throws Exception {
//        // 创建邮件
//        MimeMessage message = new MimeMessage(session);
//
//        // 设置邮件的基本信息
//        //邮件发送人
//        message.setFrom(new InternetAddress("18720160221@163.com"));
//        //邮件接收人
//        message.setRecipient(Message.RecipientType.TO, new InternetAddress("18720160221@163.com"));//xdp_gacl@sina.cn
//        //主题
//        message.setSubject("带附件和带图片的的邮件");
//
//        // 正文
//        MimeBodyPart text = new MimeBodyPart();
//        text.setContent("xxx这是女的xxxx<br/><img src='cid:aaa.jpg'>啦啦啦", "text/html;charset=UTF-8");
//
//        // 图片
//        MimeBodyPart image = new MimeBodyPart();
//        image.setDataHandler(new DataHandler(new FileDataSource("src\\3.jpg")));
//        image.setContentID("aaa.jpg");
//
//        // 附件1
//        MimeBodyPart attach = new MimeBodyPart();
//        DataHandler dh = new DataHandler(new FileDataSource("src\\4.zip"));
//        attach.setDataHandler(dh);
//        attach.setFileName(dh.getName());
//
//        // 附件2
//        MimeBodyPart attach2 = new MimeBodyPart();
//        DataHandler dh2 = new DataHandler(new FileDataSource("src\\波子.zip"));
//        attach2.setDataHandler(dh2);
//        attach2.setFileName(MimeUtility.encodeText(dh2.getName()));
//
//        //容器1
//        // 描述关系:正文和图片
//        MimeMultipart mp1 = new MimeMultipart();
//        mp1.addBodyPart(text);
//        mp1.addBodyPart(image);
//        mp1.setSubType("related");
//
//        // 代表正文的bodypart
//        MimeBodyPart content = new MimeBodyPart();
//        content.setContent(mp1);
//
//        //容器2
//        // 描述关系:正文和附件
//        MimeMultipart mp2 = new MimeMultipart();
//        mp2.addBodyPart(attach);       //附件1bodypart
//        mp2.addBodyPart(attach2);	   //附件2borypart
//        mp2.addBodyPart(content);      //正文加图片borypart
//        mp2.setSubType("mixed");
//
//        message.setContent(mp2);
//        message.saveChanges();
//
//        //将文件内容此文件方式保存到本地
//        message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
//
//        // 返回创建好的的邮件
//        return message;
//    }
//
//}
