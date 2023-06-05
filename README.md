# todoListService

Design and implement a backend service allowing basic management of a simple to-do list.

Building a REST API with Spring Boot using an H2 in-memory database.

# tech stack used

   # Runtime Enviornment, Frameworks
  
     * Java 17
     * Spring Boot 3.1.0 
     * H2 Database(in-memory database)
     * Postman(for API testing)
     * Docker
	 
	# Key libraries
      * Junit5
      * Jacoco
      * Lombok
      * SLF4j


# Build
* Maven

# Services
* add - add an item to Todo list (Todo item has id, description, status, creation date, due date)
* change description - update the description of an item
* markItem - mark an item as done or not done with the date-time at which the item was marked as done.
* getAllItems - fetch all items (based on status as well)
* getItemsById - fetch specific item by itemId
* cron scheduled job to update past due items, this will run every 24 hours once

# How to Build Service

* mvn clean install

* build docker image using below command
  * docker build --tag=todoservice:latest .
  
* Run docker image using either of below command
  
  * docker run -p8080:8080 todoservice

# How to run test cases

mvn test

# How to run services locally

# Add Item
* path -  /todo/add
* Method - POST
* url - localhost:8080/todo/add
* Request - 
   {         
       "description": "task1",
       "dueDate": "2023-07-02"
   }          
* Response - 
  {
      "id": 1,
      "description": "task1",
      "creationDate": "2023-06-02T19:38:50.952+00:00",
      "dueDate": "2023-07-02T00:00:00.000+00:00",
      "status": "not done"
  }

# Change description of a specific Item

* path -  /todo/changedescription
* Method - PUT
* url - localhost:8080/todo/changedescription?itemId=1&description=task2

# markItem as done or not done

* path -  /todo/markItem
* Method - POST
* url - localhost:8080/todo/markItem?itemId=1&isDone=true

# getItemsById

* path -  /todo/getItemsById
* Method - GET
* url - localhost:8080/todo/getItemsById?itemId=1

# getAllItems

* path -  /todo/getAllItems
* Method - GET
* url - localhost:8080/todo/getAllItems

# getAllItems with status

* path -  /todo/getAllItems
* Method - GET
* url - localhost:8080/todo/getAllItems?status=not done

