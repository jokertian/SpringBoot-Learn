package com.jokertian.mail.controller;

import com.jokertian.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.context.Context;

@RequestMapping("/mail")
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/sendSimpleMail")
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1129058980@qq.com",
                "1129058980@qq.com",
                "简单邮件",
                "测试发送简单邮件");
    }

    @GetMapping("/sendMimeMail")
    public ResponseEntity<String> sendMimeMail() {
        return mailService.sendMimeMail("1129058980@qq.com",
                "1129058980@qq.com",
                "复杂邮件",
                "<h3>测试发送复杂邮件</h3><br>" +
                        "回复【资料】领取优质资源！<br>" +
                        "<img src='cid:logo'>");
    }

    @GetMapping("/sendTemplateMail")
    public ResponseEntity<String> sendTemplateMail() {
        Context context = new Context();
        context.setVariable("username", "joker-tian");
        return mailService.sendTemplateMail("1129058980@qq.com",
                "1129058980@qq.com",
                "测试模板邮件",
                context);
    }
}
