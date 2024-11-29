package com.example.legacy.application.event;

import com.example.legacy.domain.DomainEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class LegacyDomainEventListener {


    @TransactionalEventListener
    public void handleEvent(DomainEvent event) {

    }

}
