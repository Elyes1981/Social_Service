package com.sofrecom.authentifmou3ina.config;

import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledTask {

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleMethodAtDate(LocalDate variableDate, Runnable method) {
        LocalDate currentDate = LocalDate.now();
        long delay = ChronoUnit.DAYS.between(currentDate, variableDate);

        if (delay < 0) {
            throw new IllegalArgumentException("Variable date must be in the future");
        }

        scheduler.schedule(() -> method.run(), delay, TimeUnit.DAYS);
    }

}