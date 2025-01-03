package com.example.legacy.application.event;

import com.example.legacy.domain.DomainEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class LegacyDomainEventListener {
    private static  final String OUTPUT_BINDING = "legacy-rabbit-out";


    private final StreamBridge streamBridge;

    @TransactionalEventListener
    public void handleEvent(DomainEvent event) {
        streamBridge.send(OUTPUT_BINDING,LegacyDomainMessage.from(event));
    }

}
