package com.example.websocketssample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Controller
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/hello")
    public void greeting(String pasirinkimas) throws Exception {
        laikoZona = pasirinkimas;
    }

    public String laikoZona = "Australia/Sydney";

    @Scheduled(fixedRate = 1000)
    public void sendGreeting() {
        ZonedDateTime valandos = ZonedDateTime.now();
        ZonedDateTime klientoValandos = valandos.withZoneSameInstant(ZoneId.of(laikoZona));
        String pakeistosValandos = klientoValandos.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        messagingTemplate.convertAndSend("/topic/heyhey", pakeistosValandos);
    }
}

