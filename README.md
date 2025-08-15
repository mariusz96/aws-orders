# AWS Order
A web API in Java and AWS:
```JavaScript
POST /api/orders
{
  "orderItems": [
    {
      "productId": 2,
      "quantity": 4,
      "unitPrice": 16.60
    }
  ]
}
```
```JavaScript
201 Created
1
```
```JavaScript
GET /api/orders/1
```
```JavaScript
200 OK
{
  "orderId": 1,
  "orderItems": [
    {
      "productId": 2,
      "quantity": 4,
      "unitPrice": 16.60
    }
  ]
}
```

## Prerequisites:
- Amazon Corretto 21
- IntelliJ IDEA 2025
- Docker Desktop

## Test:
- `Run` > `Edit Configurations` > `Add New Configuration` > `JUnit` > `corretto-21, aws-orders.tests, All in package` > `Run`

## Deploy:
- Create a new Aurora PostgreSQL database
- Configure `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` properties in `application.properties` file
- Create a new ECR repository, build and push Docker image to it
- Create a new ECS cluster, new ECS task definition with ECR Docker image URI and 8080 port mapping, and new ECS service
- Add permissions and configure ECS task networking to access other created resources
- Delete all created resources to prevent ongoing charges

## AWS services used:
- ECS
- ECR
- Aurora PostgreSQL
