package com.java.microservices.order.event;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEventPlaced {
    private String orderNumber;
    private String email;
}
