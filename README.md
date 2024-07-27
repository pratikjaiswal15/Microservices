# Goal

The aim of this repository is to learn various concepts in distributed systems.

# Microservices

A distributed microservices application for currency conversion. It implements Load Balancing, Circuit Breaker, Rate Limiting, and Bulkhead patterns.

# Spring Boot Dependencies

JPA, H2 (in-memory database), Eureka, API Gateway, Spring Cloud, Zipkin, Resilience4j, FeignClient

# currency-exchange-service

This microservice returns the current market price of one currency compared to other. It uses JPA for storing data in the H2 database.
It also uses the Resilience4j dependency to implement rate limiting, retry mechanisms, and circuit breaker patterns.

# currency-conversion-service

This microservice converts one currency to another. It calls the currency-exchange-service to get the current value of a currency compared to another.
It uses the Feign client to make requests to the currency-exchange-service.

# git-localconfig-repo

This repository stores the configuration required for the limits microservice, along with different profiles.

# spring-cloud-config-server

This microservice uses the Spring Cloud Config Server to connect to a Git repository that contains configuration related to the limits-service.

# limits-service

This microservice returns API request limits for each service. It connects to the Spring Cloud Config Server to fetch configurations stored in the Git repository using the spring-cloud-starter-config.

# naming-server

This is a service registry. All microservices in the distributed system register themselves with this service.
It uses Eureka Server to keep track of all microservices.
The load balancer connects to this service to distribute load across microservices.

# api-gateway

All requests in the application go through the API Gateway. The API Gateway is responsible for authentication, load balancing, and request redirection.

# Distributed tracing using Zipkin

All microservices register with the Zipkin service for distributed tracing. All logs and metrics can be viewed in the Zipkin server endpoint.

# Docker Compose

All the resources can be deployed using docker-compose file
