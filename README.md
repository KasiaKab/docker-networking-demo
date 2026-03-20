# Docker Networking Demo

A demo project showing how to use a **Dockerfile**, **Docker Compose**, and **Docker networking** to run a Spring Boot app with MongoDB.

## Tech Stack

- **Java 21** / Spring Boot 3.2
- **Spring Data MongoDB** + Lombok
- **Docker** (Dockerfile, Docker Compose, Docker networking)
- **MongoDB** + **Mongo Express**

## Services

| Service         | Image          | Port  | Description                        |
|-----------------|----------------|-------|------------------------------------|
| `mongodb`       | mongo          | 27017 | MongoDB database                   |
| `mongo-express` | mongo-express  | 8081  | MongoDB web admin UI               |
| `my-docker-app` | (built locally)| 8080  | Spring Boot application            |

## Dockerfile

The Dockerfile uses a **multi-stage build**:

- **Stage 1 (build):** Uses `maven:3.9-eclipse-temurin-21-alpine` to compile the app and package it as a JAR.
- **Stage 2 (runtime):** Uses `eclipse-temurin:21-jre-alpine` to run the JAR in a lightweight image.

The `SPRING_PROFILES_ACTIVE=docker` environment variable is set in the Dockerfile so the app automatically uses the `docker` Spring profile, which configures it to connect to MongoDB via the `mongodb` container hostname.

## Run

```bash
docker compose up --build
```

- App: http://localhost:8080
- Mongo Express: http://localhost:8081
