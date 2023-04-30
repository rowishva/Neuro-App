# Neuro-App

This is REST API which is built using Spring Boot, Docker and contain CRUD operations. Code repository has been pushed into GitHub and can be available as public repository in this location.
Technology Stack
+ Java 17
+ Spring Boot 3
+ Spring Boot Rest API
+ Spring AOP
+ Junit
+ modelmapper 3.1
+ lombok
+ Docker
+ Fabric8 Maven Plugin for generating and publish Docker image
+ Postgresql

### Run this Spring Boot App
This Neuro-App can be run as stand along application since it embedded with http Server.

### Run this in Docker environment 
This Fin-App can be run in docker environment using below mentioned steps
1.	Build docker image using Fabric8 maven plugin
```
Command : mvn package docker:build
```
2.	Execute below command in root folder where docker-compose file has been placed
```
Command : docker-comppse up
```

### Test using Postman
### Create Product
![image](https://user-images.githubusercontent.com/67745525/235357857-a5e4b251-d00a-44f3-8ff1-639d61ad17de.png)

### Update Product
![image](https://user-images.githubusercontent.com/67745525/235357867-1357e9ba-d13a-4f41-a80a-1eb058098bcc.png)

### Delete Product
![image](https://user-images.githubusercontent.com/67745525/235357888-cda0f688-0ba9-49fe-afda-ab34d4d8af52.png)

### Get All Product
![image](https://user-images.githubusercontent.com/67745525/235357937-eb14ebe7-6b50-4d56-92c4-a423901b10bc.png)

### AOP Log
![image](https://user-images.githubusercontent.com/67745525/235358097-ba8edb2b-7fdd-4703-84d0-de3660e426bb.png)

### Project structure
![image](https://user-images.githubusercontent.com/67745525/235357953-786b48cd-0a2b-4738-8ea6-1406bf2d6bf0.png)

 

