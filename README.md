# Payment Service

A Spring Boot microservice for processing payments, registered with a Eureka discovery server.

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Cloud Netflix Eureka Client
- Spring Data Redis (Lettuce)
- Spring Cache
- Jackson Databind
- Lombok

## Configuration

| Property | Value |
|---|---|
| Port | `8082` |
| App Name | `payment-service` |
| Eureka Server | `http://localhost:8008/server/eureka/` |

### Redis Configuration

| Property | Value |
|---|---|
| Host | `localhost` |
| Port | `6379` |
| Cache Type | `redis` |
| Cache Null Values | `false` |
| SSL Enabled | `true` |
| Cache TTL | `45 days` |
| Serializer | `GenericJackson2JsonRedisSerializer` |

Redis connection is managed via `LettuceConnectionFactory` with host and port bound from `spring.data.redis.*` properties using `RedisConfigProperties`.

> To enable SSL (e.g. for AWS ElastiCache), uncomment `.useSsl()` in `RedisConfig.java`.

## Caching Behavior

| Operation | Annotation | Cache Key |
|---|---|---|
| `processPayment` | `@CachePut` | `orderId` |
| `getPaymentByOrderId` | `@Cacheable` | `orderId` |

Cache name: `paymentService`

## API Endpoints

### Process Payment
```
POST /payments
```
**Request Body:**
```json
{
  "orderId": "order-123",
  "amount": 99.99
}
```
**Response:**
```json
{
  "paymentId": "<uuid>",
  "orderId": "order-123",
  "amount": 99.99,
  "status": "SUCCESS"
}
```

### Get Payment by Order ID
```
GET /payments/{orderId}
```
**Response:**
```json
{
  "paymentId": "<uuid>",
  "orderId": "order-123",
  "amount": 99.99,
  "status": "SUCCESS"
}
```
> Returns `status: PAYMENT DETAILS NOT_FOUND` if no payment exists for the given `orderId`.

## Running the Service

```bash
mvn spring-boot:run
```

> Ensure the Eureka server is running at `http://localhost:8008` and Redis is available at `localhost:6379` before starting this service.
