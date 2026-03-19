# Docker Networking Demo

A Spring Boot application that demonstrates Docker networking by running a User Profile CRUD service alongside MongoDB and Mongo Express, all orchestrated with Docker Compose.

## Tech Stack

- **Java 21** / Spring Boot 3.2
- **Spring Data MongoDB**
- **Docker** (multi-stage build) & **Docker Compose**
- **Mongo Express** – browser-based MongoDB admin UI

## Prerequisites

- Docker & Docker Compose installed, **or**
- Java 21 + Maven 3.9 and a running MongoDB instance (for local development)

## Running with Docker Compose

```bash
docker compose up --build
```

| Service        | URL                        | Description              |
|----------------|----------------------------|--------------------------|
| App            | http://localhost:8080       | User Profile App (UI & API) |
| Mongo Express  | http://localhost:8081       | MongoDB admin UI         |
| MongoDB        | localhost:27017             | Database                 |

The app uses the `docker` Spring profile (see `application-docker.properties`), which points to the `mongodb` service name for inter-container DNS resolution.

## Running Locally

1. Start a local MongoDB instance on port `27017` with credentials `mongoadmin / password`.
   > **Note:** The credentials are defined in `docker-compose.yml` and `application.properties`. Change them before deploying to a non-local environment.
2. Build and run the application:

```bash
mvn spring-boot:run
```

The app will start on http://localhost:8080 using `application.properties` (MongoDB at `localhost:27017`).

## API Endpoints

| Method | Endpoint          | Description                  |
|--------|-------------------|------------------------------|
| GET    | `/get-profile`    | Retrieve the user profile    |
| POST   | `/update-profile` | Update name, email, interests|

## Project Structure

```
src/main/java/com/kasiakab/dockernetworkingdemo/
├── DockerNetworkingDemoApplication.java   # Entry point
├── controller/UserProfileController.java  # REST endpoints
├── model/UserProfile.java                 # MongoDB document model
└── repository/UserProfileRepository.java  # Spring Data repository

src/main/resources/
├── application.properties                 # Local configuration
├── application-docker.properties          # Docker configuration
└── static/index.html                      # Frontend UI
```
