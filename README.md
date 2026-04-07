# Payment Service

A Spring Boot microservice for processing payments, registered with a Eureka discovery server.

## Tech Stack

- Java 17
- Spring Boot 3.2.5
- Spring Cloud Netflix Eureka Client
- Lombok

## Configuration

| Property | Value |
|---|---|
| Port | `8082` |
| App Name | `payment-service` |
| Eureka Server | `http://localhost:8008/server/eureka/` |

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
> Returns `status: NOT_FOUND` if no payment exists for the given `orderId`.

## Running the Service

```bash
mvn spring-boot:run
```

> Ensure the Eureka server is running at `http://localhost:8008` before starting this service.
