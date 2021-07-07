# springboot-securitywithJPA-H2database-crud-endpoints

#Note about the spring boot project source code.

1. Concepts included : spring boot + srping secuirty with JPA + H2 DB + CRUD endpoints + Exception Handling

2. Starter Depencies are added in the class path : spring boot starter-web, starter-data-JPA, starter-actuator, starter-security, devtools, lombok, h2database 

3. Database is H2 DB if you want to use Mysql or Oracle then just go & change the DB config in yml file accordingly.

4. Start the application

5. Added below list of users to authenticate & authorization post start the application. 

    INSERT INTO USER(id, user_name, password, enabled, roles) values(2, 'sai', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, 'ROLE_USER');
	INSERT INTO USER(id, user_name, password, enabled, roles) values(1, 'virupaksha', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, 'ROLE_ADMIN, ROLE_USER');
	INSERT INTO USER(id, user_name, password, enabled, roles) values(3, 'Deeraj', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, '');
	INSERT INTO USER(id, user_name, password, enabled, roles) values(4, 'Raj', '$2y$12$ofkIpFsjpB6EkH3aq8l99.wA5Lh/6AsfJSAwrtdhm1Gqq1sAuqafq', true, 'ROLE_USER');
	
	
6. Hashed password is used. you can get the generated hashed password from the below Bcrypt-password generator online link.
   https://bcrypt-generator.com/
   
7. you can find the post-man script to access the endpoints. json script file is located at the same location.

   file name: SpringBoot+SecuirtyWithJPA.postman_collection.json
