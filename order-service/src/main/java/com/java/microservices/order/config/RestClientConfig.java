package com.java.microservices.order.config;

import com.java.microservices.order.client.InventoryClient;
import io.micrometer.observation.ObservationRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Configuration
@RequiredArgsConstructor
public class RestClientConfig {


    @Value("${inventory.url}")
    private String inventoryServiceUrl;
    private final ObservationRegistry observationRegistry;
    @Bean
    public InventoryClient inventoryClient(){
        RestClient customClient = RestClient.builder()
                .baseUrl(inventoryServiceUrl)
                .observationRegistry(observationRegistry)
                .build();
        var restClientAdapter = RestClientAdapter.create(customClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}
