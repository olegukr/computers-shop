Se requiere desarrollar un programa que modele una tienda de computadores. La tienda posee los siguientes atributos:
Nombre de la tienda.
Propietario de la tienda.
Identificador tributario de la tienda.
Los computadores de la tienda tienen los siguientes atributos:
Marca del computador.
Cantidad de memoria.
Características del procesador.
Sistema operativo.
Precio del computador.
El programa debe poseer métodos que permitan:
Agregar un computador a la tienda.
Eliminar un computador de la tienda dada su marca.
Buscar un computador en la tienda dada su marca.
Listar la información de todos los computadores que tiene la tienda.
Requisitos:
Diagrama UML de clases
Tests unitarios obligatorios (cobertura mínima 70%)
Entregables:
Repositorio de Github
Captura de pantalla del diagrama de clase o enlace público al archivo de diagrams.net
Captura de pantalla de la sección testing de VSCode que muestre que se ha complido con la cobertura de tests

---

A program needs to be developed to model a computer store. The store has the following attributes:
Store name.
Shop owner.
Store tax ID.
The computers in the store have the following attributes:
Computer brand.
Amount of memory.
Processor features.
Operating system.
Computer price.
The program must have methods that allow:
Add a computer to the store.
Remove a computer from the store given its brand.
Search for a computer in the store given its brand.
List the information of all the computers that the store has.
Requirements:
UML class diagram
Mandatory unit tests (minimum coverage 70%)
Deliverables:
Github repository
Screenshot of class diagram or public link to diagrams.net file
Screenshot of VSCode's testing section showing that test coverage has been met

---
```mermaid
classDiagram
    class Computer {
        - Long id
        - String brand
        - int memory
        - String processorFeatures
        - String operatingSystem
        - double price
        - int quantity
        - Store store
    }

    class Store {
        - Long id
        - String name
        - String owner
        - String taxId
        + List~Computer~ computers
    }

    class Customer {
        - Long id
        - String name
        - String email
        - String phoneNumber
    }

    class Order {
        - Long id
        - Date orderDate
        - double totalAmount
        - Customer customer
        - List~OrderItem~ items
    }

    class OrderItem {
        - Long id
        - int quantity
        - Computer computer
        - Order order
    }

    Computer --> Store : belongs to
    Store --> Computer : manages *
    Order --> Customer : placed by
    Order --> OrderItem : contains *
    OrderItem --> Computer : references
