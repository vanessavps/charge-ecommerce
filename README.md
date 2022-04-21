# Charge e-commerce assignment

## Swagger

You can find Swagger API on http://localhost:8080/charge/swagger-ui/index.htm

## Assignment requirements

```
Implement a basic server to support a small hardware store. The server should be capable of listing a collection of
products, creating new products, and deleting products. Additionally, users should be able to submit an order for a
collection of products (that would typically have been put into a shopping cart in the browser), which should also be
persisted somehow.
Write a brief design document examining the tradeoffs behind any supporting technology you choose to use or not
use (eg. language, framework, remote procedure API, database), and any applicable design patterns.
We don’t expect more than a couple of hours to be spent, so it’s also valuable to list shortcomings and things you
chose not to implement due to time pressure.

Features
• customers should be able to view a list of all products
• administrators should be able to add new products to the system
• administrators should be able to modify existing products in the system
• administrators should be able to remove products from the system
• customers should be able to place an order that includes a collection of products in varying quantities
```

## Design document

### Frameworks and library

- Spring Boot is an easy and fast way to build an application without wasting time on configuring the environment.
- Spring Data JPA allows writing less boilerplate code, but it can have performance issues.
- Spring Security to apply security layers in the application.
- Spring Doc is a fast way to generate API documentation. No configuration needed.

### Time pressure decisions

I assumed this would be a MVP so these were my decisions to deliver a working application with technical debts we could
fix in the future:

- This application is working as guest checkout. The User database is there to identify the order owner but no user
  account is created.
- I started designing the database to support shopping cart and order as separated things
    - Shopping cart would be the "session" management
    - Order would store the submitted order
- I end up only using the Order table. Client side could handle the session for now.
- It's recommended to create DTOs to not expose database structure but for now I'm using Entity on controller.
- There's no validation, error handling and test in this application
- It would be nice to manage admin users but for now the user admin was hardcoded.

