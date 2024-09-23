package com.java.microservices.order.service;

import com.java.microservices.order.client.InventoryClient;
import com.java.microservices.order.dto.OrderRequest;
import com.java.microservices.order.event.OrderEventPlaced;
import com.java.microservices.order.model.Order;
import com.java.microservices.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String, OrderEventPlaced> kafkaTemplate;

    private String email="narender0531@gmail.com";
    public void placeOrder(OrderRequest orderRequest){

        boolean inStock = inventoryClient.isInStock(orderRequest.getSkuCode(), orderRequest.getQuantity());
        // Map Order request to order object
        if(inStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.getSkuCode());
            order.setPrice(orderRequest.getPrice());
            order.setQuantity(orderRequest.getQuantity());
            //save order to order repository
            orderRepository.save(order);

            OrderEventPlaced orderEventPlaced=new OrderEventPlaced(order.getOrderNumber(),email);
            log.info("Start sending OrderPlacedEvent {} to kafka topic order-placed", orderEventPlaced);
            kafkaTemplate.send("order-placed",orderEventPlaced);
        }else{
            throw new RuntimeException("Product with SkuCode "+orderRequest.getSkuCode()+ "is not in stock");
        }




    }
}
