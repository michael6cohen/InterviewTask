# Async Task Processor – Spring Boot + Redis

This project demonstrates asynchronous task execution and progress tracking using Spring Boot, Redis, and multi-threading.

## Features

- Create tasks with multiple subprocesses
- Asynchronous execution using `@Async`
- Status tracking and Redis-based persistence
- Swagger UI for easy API testing

## Tech Stack

- Java 17
- Spring Boot 3.x
- Redis
- SpringDoc OpenAPI (Swagger)
- Docker

## Prerequisites

- Java 17+
- Maven
- Redis (locally or via Docker)
- Docker (for containerized deployment)

---

## Docker Image

This project is also available as a pre-built Docker image on Docker Hub:  
**[michael6cohen/async-task-processor](https://hub.docker.com/r/michael6cohen/async-task-processor)**

---

## How to Run

###  Option 1: Run the app directly

If you already have Redis running (locally or in Docker), you can run the app directly using the Docker image:

```bash
docker pull michael6cohen/async-task-processor
docker run -p 8080:8080 \
  -e SPRING_REDIS_HOST=host.docker.internal \
  michael6cohen/async-task-processor
```

### Option 2: Run with Docker Compose

This project includes a ready-to-use [`docker-compose.yml`](./docker-compose.yml) file for running both Redis and the application together with a single command.

#### Usage:

1. Make sure Docker is installed and running.
2. From the root of the project (where `docker-compose.yml` is located), run:

```bash
docker-compose up --build

