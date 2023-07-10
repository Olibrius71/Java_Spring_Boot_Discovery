# Java Spring Boot Discovery Project
Memory Madness: Project made with Java Spring Boot with Thymeleaf, LESS, JQuery (+JQuery UI) and PostGreSQL to discover the Framework

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
* Creating new entities in DB with @RequestParam attributes that come from AJAX calls

I used Thymeleaf as a template-engine for such things:
* Use of a layout
* Use of Model and Session variables
* Use of if blocks (for example to display an error/warning message if model variable "accountAlreadyExists" is not null)
* Use of fragments with th:replace to import and use components

I also learned LESS with many of its functionalities.

I coded a Memory game using JavaScript, JQuery and JQuery UI, I also used AJAX calls during the coding of the game.
Here is the conduct of the game:
* It contains 12 pairs of playing cards (going from 9 to Ace)
* At first, it leaves the user some time to see the cards face up,
* Afterward, all the cards go face down and the user has a predefined amount of time (currently 30 seconds but I am planning to give the possibility to the user to choose this parameter) to find all the pairs one by one
* The process to finding cards is the following: the user selects a card then a second card, if they are the same value and the same color (example: the Jack of ♦️ and the Jack of ♥️), they stay face up and the player has found one more of the 12 pairs, otherwise, they go back face down
* There is a progress bar that shows the time left to find all the pairs, if the user successes in finding all the pairs before that progress bar (for now set to 30 seconds) empties itself, he wins the game, otherwise if he misses time, he loses the game 
* When a game ends, win or lose, the stats of the game are saved in the user's account (in the PostGreSQL database using Hibernate)

I am Planning to give users the possibility see the stats of all their games and to compare them to those of other users and i might implement some other functionalities
