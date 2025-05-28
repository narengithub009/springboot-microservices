package com.java.microservices.inventory.controller;

import com.java.microservices.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)

    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }
}

// The InventoryController class is a Spring REST controller that handles requests related to inventory.
// It has an endpoint to check if a product with a specific SKU code is in stock, based on the provided quantity.
// The controller uses InventoryService to perform the business logic and returns a boolean response indicating stock availability.
// The @RequiredArgsConstructor annotation is used to generate a constructor for dependency injection of the InventoryService.
// The @GetMapping annotation maps HTTP GET requests to the isInStock method, and @ResponseStatus(HttpStatus.OK) specifies the HTTP status code for successful responses.
