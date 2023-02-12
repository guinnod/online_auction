# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

## Using technologies:
* Swagger 2
* Mongodb database
* Maven
* Spring Security

## To execute program
* install all maven dependencies
* create application.properties file in src/main/resources folder and write mongodb connection data
* open localhost:8080/user/add and register, then open /login page and authorize
* open localhost:8080/swagger-ui.html page to make requests

## About requirements
* Application has opportunities to test api methods and make requests using Swagger UI 2
* Application is built using maven technologies
* Application is written in Java 17 and on developing process has been used Spring Boot version 2.5.9
* Application uses Spring Security for authentication. Simple authentication with cookies. Also have public and authorized routes
* Application writes logs to file named auction_platform.log
* Application is build in .jar file
* You can execute application reading text above(To execute program)
* Was ignored application.properties, .idea files. All other files is available in this repository
* Application write logs type of info in format "To: ${user} Text: ${content}", to write email to users.

## Explaining the functionality of application
* Bulletin board is in public route. You can see active and non-active bulletins on "/" route. 
You can filter active and non-active bulletins on "/filter" page.
Sorting filters are available on "/sort" page. By using bulletin name as parameter
on page "/bulletin/?name=${bulletin name}" you can get wanted bulletin. 
Page"/bulletin/image" with same parameters shares you image of product.
* Application has private and public routes. To post bulletin or to buy product
you must authorize. For registration post JSON object to "/user/add" page. 
User email is used as unique id, login and data for connection.
* Authorized user can post bulletin on "/home/add" route.
* On post request you should use form with mediafile and other required data.
Also you must define duration, which bulletin will be available for buying.
* You can see non-active bulletins but for buying only active ones.
* Buying is available on "/home/buy" route. You should know name of product which you want to buy to use it as parameter of request.