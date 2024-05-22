package com.CafeBar.LaFloridita.controllers;

import com.CafeBar.LaFloridita.services.EmailService;
import com.CafeBar.LaFloridita.dto.EmailDTO;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/lafloridita")
public class EmailController {

    @Autowired
    private EmailService emailService;


    @PostMapping("/sendemail")
    private ResponseEntity<String> sendEmail(@RequestBody EmailDTO emailDTO) throws MessagingException {


        emailService.sendEmail(emailDTO);
            return new ResponseEntity<>("Email enviado correctamente", HttpStatus.OK);
    }


}



//@PostMapping("/sendemail")
//public String sendEmail(@RequestBody FormDTO formDTO) {
//
//    try {
//        SimpleMailMessage clinicMessage = new SimpleMailMessage();
//        clinicMessage.setTo("lafloriditacafe@gmail.com");
//        clinicMessage.setFrom("lafloriditacafe@gmail.com");
//        clinicMessage.setSubject("Nuevo mensaje de LaFloridita Café Bar");
//        clinicMessage.setText(
//                "Name: " + formDTO.firstName() + "\n" +
//                        "Email: " + formDTO.email() + "\n" +
//                        "Message: " + formDTO.message()
//        );
//
//        javaMailSender.send(clinicMessage);
//
//
//        MimeMessage userMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper userMessageHelper = new MimeMessageHelper(userMessage, true);
//
//        userMessageHelper.setTo(formDTO.email());
//        userMessageHelper.setFrom("lafloriditacafe@gmail.com");
//        userMessageHelper.setSubject("Gracias por contactarnos - La Floridita Café Bar");
//
//        String userHtmlContent =
//                "<div style='background-color: #f3f4f6; padding: 24px;'>" +
//                        "<div style='max-width: 480px; margin: 0 auto; background-color: #ffffff; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.1); overflow: hidden;'>" +
//                        "<div style='padding: 24px;'>" +
//                        "<img src='cid:floriditaLogo' alt='Logo La Floridita' style='display: block; margin: 0 auto; max-width: 200px; margin-bottom: 24px;'/>" +
//                        "<h2 style='font-size: 24px; font-weight: bold; color: #333333; margin-bottom: 16px; text-align: center;'>Gracias por comunicarse con La Floridita Café Bar!</h2>" +
//                        "<p style='color: #666666; margin-bottom: 24px;'>Estimado, " + formDTO.firstName() + ":</p>" +
//                        "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Gracias por comunicarte con nosotros. Recibimos tu consulta y nos pondremos en contacto contigo lo antes posible. Valoramos tu paciencia y comprensión.</p>" +
//                        "<p style='color: #666666; margin-bottom: 24px; text-align: justify;'>Si tenés alguna pregunta o inquietud urgente, no dudes en contactarnos directamente al <a href='tel:+123456789'>+1 (234) 567-89</a>.</p>" +
//                        "<p style='color: #666666; margin-bottom: 24px;'>Desde ya muchas gracias, deseando que tengas una excelente jornada,</p>" +
//                        "<p style='font-weight: bold; color: #51280D;'>La Floridita Café Bar</p>" +
//                        "</div></div></div>";
//
//
//        userMessageHelper.setText(userHtmlContent, true);
//
//        FileSystemResource file = new FileSystemResource(new File("E:/Desktop/Proyectos/LaFloridita/LaFloridita - Front/public/LogoFloriditaBordo.avif"));
//
//
//        userMessageHelper.addInline("floriditaLogo", file);
//
//
//
//        javaMailSender.send(userMessage);
//
//        return "Email succesfully sent";
//    } catch (Exception e) {
//        return "Error in sending email " + e.getMessage();
//    }
//}





