# Digital Library

A digital library for managing books, built using Spring Boot, MySQL, and RESTful APIs. The application allows users to borrow and return books, with an automated penalty calculation if a book is not returned within 10 days. Robust unit testing is implemented using JUnit and Mockito to ensure high reliability and accuracy.


## Database Tables



| Table Name | Fields     | Data Type                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)

Takes two numbers and returns the sum.


## Tech Stack

**Framework:** SpringBoot, Hibernate

**Database:** MySQL


## 🚀 About Me
I'm a Java Backend Developer.

