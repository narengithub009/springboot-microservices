package com.java.microservices.order.service;

import com.java.microservices.order.event.OrderEventPlaced;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j

public class NotificationService {

    @KafkaListener(topics = "order-placed")
    public void listen(OrderEventPlaced orderEventPlaced){
        log.info("Got message from order-placed topic {}", orderEventPlaced);
        log.info("Notification has been sent...");

    }
}
