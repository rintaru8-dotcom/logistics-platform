# 🚚 SoftMotion Logistics Platform

**Full-Stack Spring Boot Microservices for Logistics Systems**

> Built by [SoftMotion Studio](https://github.com/rintaru8-dotcom) 🏢

---

## 📦 Overview

A complete, production-ready microservices platform for logistics management.
Modernize your legacy monolithic logistics system into clean, scalable microservices using Spring Boot and Kubernetes.

---

## 🏗️ Architecture

```
[API Gateway]  ← coming soon
      │
 ┌────┼────┐
 ↓    ↓    ↓
在庫  注文  配送
8081 8082 8083
```

---

## ✅ Services

| Service | Port | Description |
|---------|------|-------------|
| **inventory-service** | 8081 | Stock management |
| **order-service** | 8082 | Order management |
| **delivery-service** | 8083 | Delivery tracking |
| api-gateway | - | 🔜 Coming soon |

---

## 🚀 Quick Start

### Requirements
- Java 17+
- Maven 3.9+

### Run each service

```bash
# Inventory Service
cd inventory-service
mvn spring-boot:run

# Order Service
cd order-service
mvn spring-boot:run

# Delivery Service
cd delivery-service
mvn spring-boot:run
```

---

## 📡 API Endpoints

### Inventory Service (port 8081)

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/v1/inventory | Get all items |
| GET | /api/v1/inventory/{sku} | Get item by SKU |
| POST | /api/v1/inventory | Create item |
| POST | /api/v1/inventory/{sku}/reserve | Reserve stock |

### Order Service (port 8082)

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/v1/orders | Get all orders |
| GET | /api/v1/orders/{id} | Get order by ID |
| GET | /api/v1/orders/customer/{customerId} | Get by customer |
| POST | /api/v1/orders | Create order |
| PUT | /api/v1/orders/{id}/confirm | Confirm order |
| PUT | /api/v1/orders/{id}/cancel | Cancel order |

### Delivery Service (port 8083)

| Method | URL | Description |
|--------|-----|-------------|
| GET | /api/v1/deliveries | Get all deliveries |
| GET | /api/v1/deliveries/{id} | Get by ID |
| GET | /api/v1/deliveries/order/{orderId} | Get by order |
| POST | /api/v1/deliveries | Create delivery |
| PUT | /api/v1/deliveries/{id}/transit | Start transit |
| PUT | /api/v1/deliveries/{id}/complete | Complete delivery |
| PUT | /api/v1/deliveries/{id}/fail | Mark as failed |

---

## 🗺️ Roadmap

- [x] Inventory Service
- [x] Order Service
- [x] Delivery Service
- [ ] API Gateway (Spring Cloud Gateway)
- [ ] Kafka event streaming
- [ ] Docker Compose (one-command startup)
- [ ] Kubernetes manifests
- [ ] PostgreSQL production config

---

## 📄 License

- **Personal / Non-commercial use** — Free ✅ (MIT License)
- **Commercial use** — Please contact us 📩

© 2026 SoftMotion Studio. All rights reserved.

---

## 🤝 Contact

- GitHub: [@rintaru8-dotcom](https://github.com/rintaru8-dotcom)
- LinkedIn: [SoftMotion Studio](https://www.linkedin.com/in/)

---

⭐ If this helped you, please give it a star!
