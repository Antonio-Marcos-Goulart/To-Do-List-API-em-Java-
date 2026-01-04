# To-Do List API – Java & Spring Boot

## Português

API REST para gerenciamento de tarefas (To-Do List), desenvolvida em Java 21 com Spring Boot 3.4.1.

Este projeto marca a retomada dos estudos e práticas de desenvolvimento backend após o período de férias, com foco em reforçar fundamentos, aplicar boas práticas de arquitetura e consolidar conhecimentos em Spring Boot, JPA e APIs REST.

---

### Visão Geral

A API permite criar, listar, atualizar e remover tarefas, oferecendo suporte a validações, organização por grupos e documentação automática por meio do Swagger/OpenAPI.

Os principais objetivos do projeto são:
- Retomar a prática de desenvolvimento backend com Spring Boot
- Reforçar conceitos de arquitetura em camadas
- Aplicar validações com Jakarta Validation
- Persistir dados utilizando JPA e PostgreSQL
- Documentar APIs REST de forma padronizada e profissional

---

### Tecnologias Utilizadas

- Java 21
- Spring Boot 3.4.1
- Spring Data JPA
- Jakarta Validation (Hibernate Validator)
- PostgreSQL
- SpringDoc OpenAPI (Swagger)
- Spring Boot Actuator
- Lombok
- Dotenv
- Maven
- JUnit e Spring Boot Test

---

### Funcionalidades

- Criação de tarefas
- Listagem de todas as tarefas
- Busca de tarefas por identificador
- Atualização de tarefas existentes
- Remoção de tarefas
- Organização de tarefas em grupos
- Validação de dados de entrada
- Geração automática da documentação da API

---

### Arquitetura

O projeto adota uma arquitetura em camadas, promovendo separação de responsabilidades e maior manutenibilidade do código:

- Controller: responsável por receber e responder às requisições HTTP
- Service: responsável pelas regras de negócio
- Repository: responsável pelo acesso e persistência dos dados
- Model: entidades JPA que representam o domínio
- DTO: objetos utilizados para transferência de dados
- Config: configurações gerais da aplicação

---

## English

REST API for task management (To-Do List), developed using Java 21 and Spring Boot 3.4.1.

This project represents the return to backend development studies and practice after a vacation period, focusing on reinforcing fundamentals, applying good architectural practices, and consolidating knowledge in Spring Boot, JPA, and REST APIs.

---

### Overview

The API allows creating, listing, updating, and deleting tasks, providing support for validations, task grouping, and automatic documentation through Swagger/OpenAPI.

The main goals of this project are:
- Resume backend development practice with Spring Boot
- Reinforce layered architecture concepts
- Apply validations using Jakarta Validation
- Persist data using JPA and PostgreSQL
- Document REST APIs in a standardized and professional way

---

### Technologies Used

- Java 21
- Spring Boot 3.4.1
- Spring Data JPA
- Jakarta Validation (Hibernate Validator)
- PostgreSQL
- SpringDoc OpenAPI (Swagger)
- Spring Boot Actuator
- Lombok
- Dotenv
- Maven
- JUnit and Spring Boot Test

---

### Features

- Task creation
- Listing all tasks
- Retrieve task by identifier
- Update existing tasks
- Delete tasks
- Task grouping support
- Input data validation
- Automatic API documentation generation

---

### Architecture

The project follows a layered architecture, promoting separation of concerns and improved code maintainability:

- Controller: handles HTTP requests and responses
- Service: contains business rules
- Repository: handles data access and persistence
- Model: JPA entities representing the domain
- DTO: data transfer objects
- Config: application configuration classes
