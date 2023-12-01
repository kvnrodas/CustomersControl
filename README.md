# Web Application Documentation

## Overview

This repository contains the source code for a web application developed in Java using GlassFish and various frameworks, including Bootstrap. The application focuses on managing client information through CRUD (Create, Read, Update, Delete) operations.

## Table of Contents

1. [Servlet Controlador](#servlet-controlador)
2. [Cliente Class](#cliente-class)
3. [Conexion Class](#conexion-class)
4. [ClienteDaoJDBC Class](#clientedaojdbc-class)
5. [Web Pages](#web-pages)

## Servlet Controlador

The `ServletControlador` class serves as the main controller for handling HTTP requests related to client management. It includes methods for inserting, updating, deleting, and retrieving client information. The key functionalities include:

- Inserting a new client.
- Modifying client details.
- Deleting a client.
- Retrieving and displaying client information.

### Methods

- `doGet(HttpServletRequest request, HttpServletResponse response)`: Handles HTTP GET requests based on specified actions.
- `doPost(HttpServletRequest request, HttpServletResponse response)`: Handles HTTP POST requests based on specified actions.
- `insertar(HttpServletRequest request, HttpServletResponse response)`: Inserts a new client into the database.
- `modificarCliente(HttpServletRequest request, HttpServletResponse response)`: Modifies existing client details.
- `editarCliente(HttpServletRequest request, HttpServletResponse response)`: Retrieves client information for editing.
- `eliminarCliente(HttpServletRequest request, HttpServletResponse response)`: Deletes a client from the database.
- `calcularSaldoTotal(List<Cliente> clientes)`: Calculates the total balance of all clients.
- `accionDefault(HttpServletRequest request, HttpServletResponse response)`: Sets default actions and redirects to the client list page.

## Cliente Class

The `Cliente` class represents the model for client entities. It includes attributes such as `idCliente`, `nombre`, `apellido`, `email`, `telefono`, and `saldo`. The class provides constructors, getters, setters, and a `toString` method for convenient usage.

## Conexion Class

The `Conexion` class manages the database connection using Apache Commons DBCP. It includes methods for obtaining a data source, establishing a connection, and closing resources.

## ClienteDaoJDBC Class

The `ClienteDaoJDBC` class handles database operations related to clients, including listing, finding, inserting, updating, and deleting clients. It utilizes prepared statements for secure database interactions.

## Web Pages

The `webapp` directory contains JSP pages for the user interface. Notable pages include:

- `clientes.jsp`: Displays the list of clients.
- `editarCliente.jsp`: Allows editing client details.

## Dependencies

- Java
- GlassFish
- Bootstrap
- Apache Commons DBCP

## Setup and Configuration

1. Set up a MySQL database with the specified configuration.
2. Deploy the application on GlassFish.
3. Access the application through the specified URL.

## Usage

The application provides a user-friendly interface for managing client information. Users can perform CRUD operations seamlessly.

Feel free to add more details, such as deployment instructions, configuration steps, or any additional features. This template provides a basic structure that you can expand upon based on your project's specifics.
