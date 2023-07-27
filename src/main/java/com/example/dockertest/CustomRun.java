package com.example.dockertest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class CustomRun {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    private int count = 0;

    @Scheduled(fixedDelay = 1000)
    public void test1() {
        if (count <= 100) {
            logger.info("時間:{}啟動成功，關閉倒數" + (100 - count), LocalDateTime.now().format(formatter));
            count += 1;
        }
    }
}
