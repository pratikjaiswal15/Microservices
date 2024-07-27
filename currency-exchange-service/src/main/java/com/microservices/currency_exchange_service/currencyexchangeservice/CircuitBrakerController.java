package com.microservices.currency_exchange_service.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBrakerController {

    Logger logger = LoggerFactory.getLogger(CircuitBrakerController.class);
    @GetMapping("/sample-api")
    // @Retry(name = "sample-api", fallbackMethod = "fallbackResponse")
    // @CircuitBreaker(name = "default", fallbackMethod = "fallbackResponse")
    @RateLimiter(name = "default")
    public String sampleApi() {
        logger.info("Sample API Call Received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/invalid-url", String.class);
//		return forEntity.getBody();

        return "Sample API";
    }

    public String fallbackResponse(Exception ex) {
        return "Fallback Response";
    }
}
