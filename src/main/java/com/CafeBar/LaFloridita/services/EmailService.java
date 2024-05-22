package com.CafeBar.LaFloridita.services;

import com.CafeBar.LaFloridita.dto.EmailDTO;
import jakarta.mail.MessagingException;

public interface EmailService {

    public void sendEmail(EmailDTO emailDTO) throws MessagingException;
}
