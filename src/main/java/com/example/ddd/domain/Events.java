package com.example.ddd.domain;

import org.springframework.context.ApplicationEventPublisher;

// ApplicationEventPublisher 를 사용하여 이벤트를 발생시키는 클래스
public class Events {

    private static ApplicationEventPublisher publisher;

    public static void setPublisher(ApplicationEventPublisher publisher) {
        Events.publisher = publisher;
    }

    public static void raise(Object event) {
        if (event != null) {
            publisher.publishEvent(event); // 이벤트 발생
        }
    }
}
