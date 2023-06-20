# Java Spring Boot Discovery Project
Project made with Java Spring Boot with Thymeleaf, LESS and PostGreSQL to discover the Framework

To this day, I did a kind of basic front end and created a User Entity with UserRepository and UserService, one has the possibility to create an account and to login and logout (the app will verify that both the username and email arent already in db when creating an account and that the email is valid, username is at least 6 characters long and password at least 10 characters long with lowercase, UPPERCASE letters and digits), here are some of the spring boot concepts I learned and used:
* Configuring a Spring Boot Project
* GetMapping and PostMapping
* Creation of Entities with Advanced Properties (also used Lombok)
* Working with repositories and services to perform operations through JPA
* Using annotations such as @Entity, @Repository, @Controller, @Autowired and more
* Using model attributes with Model and handling forms submissions with @RequestParam
* Using session with HttpSession
* Working with Spring boot properties file (application.yaml)
* Troubleshooting issues in a Spring Boot Application

I used Thymeleaf as a template-engine for such things:
* Use of a layout
* Use of Model and Session variables
* Use of if blocks (for example to display an error/warning message if model variable "accountAlreadyExists" is not null)
* Use of fragments with th:replace to import and use components

I also learned LESS with many of its functionalities.

Planning to make a simple memory game with users that will save all their stats and have other functionalities
