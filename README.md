##### What program it is?

this is example of backend API about inventory, similar to warehouse software. the program use swagger as documentation. theres couple of depedency that i use in this program : 

1. mysql connector = for the database
2. junit jupiter engine and mockito junit jupiter = for testing
3. sonar maven = for sonarqube 
4. docker maven = for make it as image in docker
5. spring jpa = for sql query

and other depedency that you can see in pom.xml

ps: i add new feature soft delete and purchase in stock table. go check it out!!



##### How to use

1. make mysql database and name it as "springinventory" (without quote)
2. go to application.yml and change hibernate.ddl.auto to "create" (without quote)
3. go to source/import.sql uncomment it and change as you like
4. the first time you run it, aplication will automaticly create table(entities) for you.
5. and fill the table using data in import sql
6. look at your database,  see if the table exist now
7. if it exist, now go to application and change hibernate.ddl to "update" again
8. run the program 
9. open browser and go to localhost:8080/swagger-ui-costum.html



##### how to use(other way)

1. i'm include sql file named springinventory.sql in same place as readme.md
2. you can import it to your mysql database
3. run the program 
4. open browser and go to localhost:8080/swagger-ui-costum.html

