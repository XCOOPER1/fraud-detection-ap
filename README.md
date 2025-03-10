# Fraud Detection API

This project is a **Fraud Detection API** built with **Spring Boot**, designed to process financial transactions and flag potentially fraudulent activities.

## Features

- **Submit a transaction**: Allows users to submit a transaction with details like user ID, amount, location, and IP address.
- **Fraud detection**: Automatically flags transactions as potentially fraudulent using a custom detection service.
- **Get user transactions**: Retrieve all transactions for a specific user based on their `userId`.

## Technologies Used

- **Spring Boot**: To create the RESTful API.
- **JPA & Hibernate**: For database interaction.
- **H2 Database**: In-memory database for testing.
- **Lombok**: To reduce boilerplate code.
- **Maven**: Dependency management and build tool.

## Setup

### Prerequisites

To run this project, make sure you have the following installed:

- **Java 17+** (or compatible JDK version)
- **Maven** (for managing dependencies and building the project)

### Clone the Repository

Clone this repository to your local machine:

```bash
git clone https://github.com/yourusername/fraud-detection-api.git
cd fraud-detection-api
