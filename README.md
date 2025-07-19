
# 📦 TravelBank_K8S_ServerSideDiscovery_v15.0

This project demonstrates **Server-side Service Discovery and Load Balancing** using **Kubernetes** in a microservice architecture.

---

## 🔍 Comparison: Client-side vs Server-side Discovery

### 🧩 Client-side Service Discovery & Load Balancing

#### 🔄 Flow Overview

1. **Registration**
   - The **Loans** microservice registers itself with a Service Registry (e.g., **Eureka**) during startup.
   - Sends periodic heartbeat signals to remain active.

2. **Discovery & Invocation**
   - The **Accounts** microservice queries the registry to discover **Loans** service instances.
   - The registry responds with a list of IPs (e.g., `127.54.37.23`, `127.54.37.24`).
   - The **Accounts** microservice selects an instance using load-balancing logic (e.g., round-robin, random) and calls it.

#### ✅ Key Traits

- Load balancing is performed by the **client**.
- Offers greater flexibility but increases client complexity.

---

### ⚙️ Server-side Service Discovery & Load Balancing (Kubernetes-based)

#### 🔄 Flow Overview

1. **Dynamic Service Mapping**
   - Services like **Loans** do **not** self-register.
   - A Discovery Server queries the **Kubernetes API** to retrieve service and endpoint data.

2. **Simplified Invocation**
   - The **Accounts** microservice sends a request using the Kubernetes **service name** (e.g., `http://loans`).
   - Kubernetes (via kube-proxy/CoreDNS) automatically load balances the request to a healthy instance (e.g., `127.54.37.2`).

#### ✅ Key Traits

- Load balancing is managed by **Kubernetes**.
- Reduces manual configuration for client services.
- Simplifies architecture, with discovery abstracted from the client.

---

## 🔁 Summary Table

| Feature                   | Client-side Discovery     | Server-side Discovery (K8s) |
|---------------------------|---------------------------|-----------------------------|
| Service Registration      | Manual (e.g., Eureka)     | Automatic via K8s API       |
| Who Queries for Endpoints | Client                    | Kubernetes                   |
| Load Balancer Location    | On client                 | On server (Kubernetes)       |
| Client-side Complexity    | Higher                    | Lower                        |
| Flexibility               | High                      | Tied to infrastructure       |

---

## 🛠 Technologies Used

- Java, Spring Boot
- Kubernetes (K8s)
- Microservices Architecture
- Optional: Eureka (for client-side discovery demo)
- Docker

---

## 📁 Folder Structure

```
TravelBank_K8S_ServerSideDiscovery_v15.0/
├── accounts-service/
├── loans-service/
├── gateway-service/
├── k8s-manifests/
└── README.md
```

---

## 🚀 Getting Started

To deploy to Kubernetes:

```bash
kubectl apply -f k8s-manifests/
```

Ensure you have Docker images built and pushed to a registry accessible by your K8s cluster.

---

## 📌 Author

**TravelBank Engineering Team**  
💬 Contact: vinay@example.com

---

> Need a visual representation? Ping for a minimalist architecture diagram or slide-style layout! 🎨
