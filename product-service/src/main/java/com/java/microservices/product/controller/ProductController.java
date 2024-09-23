package com.java.microservices.product.controller;

import brave.Response;
import com.java.microservices.product.dto.ProductRequest;
import com.java.microservices.product.dto.ProductResponse;

import com.java.microservices.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest productRequest){
       // log.info("Incoming request: POST /api/products, Request Body: {}", productRequest);
        ProductResponse productResponse = productService.createProduct(productRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        /*try{
          Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        List<ProductResponse> allProducts = productService.getAllProducts();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Products-Count", String.valueOf(allProducts.size()));
        log.info("Product details: {} products retrieved ",allProducts.size());
        return ResponseEntity.ok().headers(headers).body(allProducts);
    }
}
