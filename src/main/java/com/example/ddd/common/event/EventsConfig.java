package com.example.ddd.common.event;

import com.example.ddd.domain.Events;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventsConfig {

    private final ApplicationContext applicationContext;

    public EventsConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Bean
    public InitializingBean eventsInitializer() {
        // Events 클래스 초기화
        return () -> Events.setPublisher(applicationContext);
    }
}
