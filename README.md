# Employee-Management-System


[!["JAVA"](https://img.shields.io/badge/Java-ff8800?style=for-the-badge&logo=java&logoColor=white)](https://www.java.com) 
[!["Spring Boot"](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://spring.io/projects/spring-boot) [!["Maven"](https://img.shields.io/badge/Maven-0769AD?style=for-the-badge&logoColor=white)](https://mvnrepository.com/)
[!["HTML5"](https://img.shields.io/badge/HTML5-E34F26?style=for-the-badge&logo=html5&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/Guide/HTML/HTML5) [!["JavaScript"](https://img.shields.io/badge/JavaScript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black)](https://developer.mozilla.org/en-US/docs/Web/JavaScript) 
[!["Css3"](https://img.shields.io/badge/CSS3-1572B6?style=for-the-badge&logo=css3&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/Css) 
[!["Bootstrap"](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)](https://getbootstrap.com/) 
[!["MySql"](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)](https://www.mysql.com/) 
[!["Github"](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https:/www.github.com/) 

## **Table of Contents**
  - [**Employee Management System**](#employee-management-system)
  - [**Requirements Analysis**](#requirements-analysis)
  - [**Design Pattern**](#design-pattern)
  - [**Language and Tool Selection**](#language-and-tool-selection)
  - [**Database Scripting With Spring Data JPA**](#database-scripting-with-spring-data-jpa)
  - [**Advantage of Spring JpaTemplate**](#advantage-of-spring-jpatemplate)

## **Employee Management System**
Here, this website helps to manage the employee and department record. It is usually used in organization to store the detail on employee and department. 

## **Requirements Analysis**

Summarizing all the user requirements we can conclude the following measures as the actual user requirements. According
to client requirements we must create an inventory application with following requirements:

1. __User__
    1. Register, login
1. __Department__
    1. add, update, delete, list and view Department
    2. department list
1. __Employee__
    1. add, update, delete, list and view Employee
    1. Employee detail

Briefing out the requirements, I will be creating an website which can store details of employee, department.

## **Design Pattern**
In order to implement a model I have used MVC template. 
1. Create a pojo file. give annotation like @Entity, @Data, @Table
2. Map the pojo file to database (JPA repository)
3. Make a repository
4. Make an interface (services)
5. Make an implementation class for implementing interface abstract method
6. Make a controller consisting getMapping and postMapping
7. Finally, make view (html template)


## **Language and Tool Selection**
The list of tools used while developing the project are as follows.

````
Backend : Java, Spring Boot Framework
Package Manager: Maven
Server : Apache Tomcat
Frontend : Html5, Thymeleaf
Styling : Bootstrap, Css
Documentation : MarkDown (MD)
Database : MySQL
Database Management system : MySQLyog
IDE : Spring Tool Suite
Version Control : GitHub
Project Manager : GitHub Projects
Development OS: Windows 10 Home Edition
````

## **Database Scripting With Spring Data JPA**
`Spring Data JPA API` provides __JpaTemplate__ class to integrate spring application with JPA. It is currently used as the replacement for complex entity beans.

The implementation of JPA specification are provided by many vendors such as:
- Hibernate
- OpenJPA etc.

### **Advantage of Spring JpaTemplate**
Really handy for persisting, updating, deleting or searching object. JPA handles most of the complexity of JDBC-based database access and object-relational mappings. On top of that, Spring Data JPA reduces the amount of boilerplate code required by JPA.

Spring Data JPA helps to generate database itself using JPA API Under the hood configured with moduls you create. 
[Readmore about Spring Data JPA](https://spring.io/projects/spring-data-jpa)
</p>
