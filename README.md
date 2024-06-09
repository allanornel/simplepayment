# Project Simple Payment

User and Transaction Management API

## Introduction

This project is a simple RESTful API built with Java Spring Boot 3.3. It provides basic functionalities for managing users and transactions. The API supports creating and retrieving users, as well as creating transactions.

## Technologies Used
- **Java Spring Boot 3.3**: The main framework used for developing the application.
- **Spring Boot Data JPA**: For data persistence and interaction with the database.
- **Spring Boot Web**: For building web applications and RESTful services.
- **Lombok**: To reduce boilerplate code by generating getters, setters, constructors, etc.
- **PostgreSQL**: The relational database used for data storage.
- **Flyway**: For database migrations.


## Getting Started
# Prerequisites
- Java Development Kit (JDK) 17 or later
- Maven
- PostgreSQL

  # Installation
  1. **Clone the repository:**
     
  ```bash
      git clone https://github.com/allanornel/simplepayment.git
      cd simplepayment
  ```
   
  2. **Configure the database**
  Update the application.properties file with your PostgreSQL database credentials.

  ```
    spring.datasource.url=jdbc:postgresql://localhost:5432/your-database
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    spring.jpa.hibernate.ddl-auto=update
  ```
  
  3. **Build the project:**
     
   ```bash
     mvn clean install
   ```
   
  4. **Run the application:**
     
   ```bash
     mvn spring-boot:run
   ```  

  # Endpoints
  ## User Endpoints
  Create User:
  - URL: /users
  - Method: POST
  - Response: User
  - RequestBody: UserDTO
```json
{

    "firstName": "Teste",
    "lastName": "Silva",
    "document": "12134526",
    "password": "123",
    "email":"teste@example.com",
    "userType": "COMMON",
    "balance": 50
}
```

### Get Users:
- URL: /users
- Method: GET
- Response: List<User>

  ## Transaction Endpoints
  ### Create Transaction:
- URL: /transactions
- Method: POST
- Response: Transaction
- Request Body - TransactionDTO:
```json
{
    "senderId": 1,
    "receiverId": 2,
    "value": 10
}
```
