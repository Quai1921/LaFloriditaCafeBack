package com.CafeBar.LaFloridita.services.impl;

import com.CafeBar.LaFloridita.services.EmailService;
import com.CafeBar.LaFloridita.dto.EmailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;


    @Override
    public void sendEmail(EmailDTO emailDTO) throws MessagingException {
        try {

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setTo(emailDTO.getEmail());
            helper.setSubject(emailDTO.getFirstName() + ", gracias por contactarnos - La Floridita Café");


            Context context = new Context();
            context.setVariable("firstName", emailDTO.getFirstName());
            context.setVariable("email", emailDTO.getEmail());
            context.setVariable("message", emailDTO.getMessage());
//            String html = templateEngine.process("email", context);

//            ClassPathResource imagenMail = new ClassPathResource("static/images/LogoFloriditaBordo.avif");
//            helper.addInline("floriditaLogo", imagenMail);


            String userHtmlContent =
               "<div style='background-color: #f3f4f6; padding: 24px;'>" +
                        "<div style='max-width: 480px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); overflow: hidden;'>" +
                        "<div style='padding: 24px;'>" +
                        "<img src='cid:floriditaLogo' alt='Logo La Floridita' style='display: block; margin: 0 auto; max-width: 200px; margin-bottom: 24px;'/>" +
                        "<h2 style='font-size: 24px; font-weight: bold; color: #333333; margin-bottom: 16px; text-align: center;'>Gracias por comunicarte con La Floridita Café Bar!</h2>" +
                        "<p style='color: #666666; margin-bottom: 24px;'>Estimada/o, " + emailDTO.getFirstName() + ":</p>" +
                        "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Hemos recibido tu consulta y nos pondremos en contacto lo antes posible. Valoramos tu paciencia y comprensión.</p>" +
                        "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Si tenés alguna pregunta o inquietud urgente, no dudes en contactarnos directamente al <a href='tel:+354815636144'>(3548)15 63 6144</a>.</p>" +
                        "<p style='color: #666666; margin-bottom: 24px;'>Desde ya muchas gracias, deseando que tengas una excelente jornada,</p>" +
                        "<p style='font-weight: bold; color: #51280D;'>La Floridita Café Bar</p>" +
                        "</div></div></div>";

            helper.setText(userHtmlContent, true);

//            ClassPathResource imagenMail = new ClassPathResource("static/images/LogoFloriditaBordo.avif");
//            helper.addInline("floriditaLogo", imagenMail);

            FileSystemResource file = new FileSystemResource(new File("E:/Desktop/Proyectos/LaFloridita/LaFloridita - Back/src/main/resources/static/images/LogoFloriditaBordo.avif"));
            helper.addInline("floriditaLogo", file);


//            helper.setText(html, true);
            javaMailSender.send(message);



            MimeMessage messageOwner = javaMailSender.createMimeMessage();
            MimeMessageHelper helperOwner = new MimeMessageHelper(messageOwner, true, "UTF-8");

            helperOwner.setTo("lafloriditacafe@gmail.com");
            helperOwner.setSubject("Email enviado por " + emailDTO.getFirstName());

            Context contextOwner = new Context();
            contextOwner.setVariable("firstName", emailDTO.getFirstName());
            contextOwner.setVariable("email", emailDTO.getEmail());
            contextOwner.setVariable("message", emailDTO.getMessage());

//            String htmlOwner = templateEngine.process("emailOwner", context);



            String ownerHtmlContent =
                    "<div style='background-color: #f3f4f6; padding: 24px;'>" +
                            "<div style='max-width: 480px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); overflow: hidden;'>" +
                            "<div style='padding: 24px;'>" +
//                            "<img src='cid:floriditaLogoOwner' alt='Logo La Floridita' style='display: block; margin: 0 auto; max-width: 200px; margin-bottom: 24px;'/>" +
                            "<h2 style='font-size: 24px; font-weight: bold; color: #333333; margin-bottom: 16px; text-align: center;'>Mensaje enviado por: " + emailDTO.getFirstName() + "</h2>" +
                            "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Email: " + emailDTO.getEmail() + "</p>" +
                            "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Mensaje: " + emailDTO.getMessage() + "</p>" +
                            "</div></div></div>";

            helperOwner.setText(ownerHtmlContent, true);

//            FileSystemResource fileOwner = new FileSystemResource(new File("E:/Desktop/Proyectos/LaFloridita/LaFloridita - Back/src/main/resources/static/images/LogoFloriditaBordo.avif"));
//            helperOwner.addInline("floriditaLogoOwner", fileOwner);


//            helperOwner.setText(htmlOwner, true);
            javaMailSender.send(messageOwner);

        }

        catch (Exception e) {
            throw new RuntimeException("Error al enviar el email", e);
        }


    }



}
