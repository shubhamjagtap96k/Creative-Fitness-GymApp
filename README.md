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


## User Guide (How to Use)
1. **Reset Database** (Important for first run or after schema changes):
   - Stop the app.
   - Run `docker-compose down -v` and then `docker-compose up -d`.
   - OR manually drop `gymApp_db` and recreate it.
   - Restart the Backend to let Flyway migrate the schema.

2. **Accessing the App**:
   - Open browser to `http://localhost:5173` (Frontend).
   - Click **"Create an account"** to register.
   - select **Role**: `MEMBER` or `OWNER`.
   - Login with your new credentials.

3. **Dashboard**:
   - **Members**: Can view stats (placeholder) and upcoming classes.
   - **Owners**: (Future) Will see management options.

## Troubleshooting 
- **"Password authentication failed"**: Check `application.yml` matches your Docker/Local DB credentials (`username: postgres`, `password: root` vs `gym_user/gym_password`).
- **"SchemaManagementException" / "Validation Failed"**: This means your Java Entities don't match the DB Tables. **Solution**: Drop the database and restart the backend to recreate tables correctly.
