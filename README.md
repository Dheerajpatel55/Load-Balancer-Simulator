# Load Balancer Simulator

A Java-based **Load Balancer Simulator** that demonstrates different load balancing strategies for distributing client requests across multiple servers. This project is ideal for understanding server load management, routing strategies, and concurrency handling.

---

## Table of Contents
- [Overview](#overview)
- [Features](#features)
- [Architecture](#architecture)
- [Routing Strategies](#routing-strategies)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Metrics Collection](#metrics-collection)
- [Dependencies](#dependencies)
- [Contributing](#contributing)
- [License](#license)

---

## Overview

This project simulates a load balancer that distributes client requests among multiple servers based on different routing strategies such as:

- **Round Robin**
- **Least Connections**
- **Weighted Round Robin**

Each server has configurable properties such as capacity, weight, and processing latency. The simulator also supports concurrent requests using Java threads.

---

## Features

- Simulates multiple servers with different capacities and weights.
- Supports multiple load balancing strategies.
- Handles concurrent requests.
- Collects metrics for server load and request distribution.
- Easy to extend with custom routing strategies.

---

## Architecture


- **Client**: Generates requests.
- **LoadBalancer**: Receives requests and routes them to servers using a routing strategy.
- **Server**: Processes requests concurrently and simulates latency.
- **RoutingStrategy**: Defines the algorithm for choosing a server.

---

## Routing Strategies

1. **Round Robin**: Distributes requests equally in circular order.
2. **Least Connections**: Sends requests to the server with the fewest active connections.
3. **Weighted Round Robin**: Distributes requests based on server weights.

---

## Getting Started

### Prerequisites
- Java JDK 11 or higher
- Maven (optional, if using a build tool)
- Git

### Clone the repository
```bash
git clone https://github.com/Dheerajpatel55/Load-Balancer-Simulator.git
cd Load-Balancer-Simulator
