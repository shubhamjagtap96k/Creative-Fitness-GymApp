# Creative Fitness Gym App

A secure, full-stack Gym Management application built with Spring Boot 3 and React 18.

## Tech Stack
- **Backend**: Java 17, Spring Boot 3.2.0, Spring Security (JWT), Spring Data JPA, Hibernate, PostgreSQL, Flyway.
- **Frontend**: React 18, TypeScript, Vite, Tailwind CSS, Material UI, React Query, React Router v6.
- **Database**: PostgreSQL (Dockerized).

## Setup Instructions

### Prerequisites
- Java 17+
- Node.js 18+
- Docker Desktop
- Maven (optional, wrapper included)

### Database Setup
1. Ensure Docker is running.
2. Start PostgreSQL:
   ```bash
   docker-compose up -d
   ```

### Backend Setup
1. Navigate to `/backend`.
2. Build and run (requires internet for initial dependency download):
   ```bash
   ./mvnw spring-boot:run
   ```
   *Note: If offline, ensure `.m2` repository is populated.*

### Frontend Setup
1. Navigate to `/frontend`.
2. Install dependencies:
   ```bash
   npm install
   ```
3. Run:
   ```bash
   npm run dev
   ```

## Features Implemented (Code)
- **Authentication**: JWT-based login/registration with Role-Based Access Control (Owner/Member).
- **Database Schema**: Users, Plans, Classes, Bookings tables (via Flyway).
- **Security**: Stateless session management, BCrypt password encoding.
- **Frontend Core**: Auth Context, Protected Routes, Login/Register UI, Dashboard.

## Known Issues
- Network connectivity issues prevented automatic dependency installation during development. Please run `mvn clean install` and `npm install` to hydrate the project once connectivity is restored.
