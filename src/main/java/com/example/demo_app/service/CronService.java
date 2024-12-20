package com.example.demo_app.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CronService {
    @Scheduled(cron = "${cron.test}")
    public void cron() {
        System.out.println("\n"+ LocalDateTime.now() +"\n");
    }
}
