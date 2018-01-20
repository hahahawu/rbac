# RBAC

***

> By hahahawu

This repository contains the source code of RBAC system.

# Introduce

***

RBAC is the abbreviation of Role-Based Accss Control. According to the different role, different elements and operation will be displayed in the page.

The user, roles, userGroup, privileges,elements and operations are saved at local databases.
The program will read these data and deal with them. Finally, return a page which contains the elements and the operations that you have privilege to see.

The project use spring-boot, spring-framework, spring-data-jpa, thymeleaf, bootstrap-material-design and gradle.

# How to run
***

1.import the project into your IDE(I used idea.)

2.install gradle

3.build gradle

4.update databases connection configuration

5.compile java code

6.package and deploy

# Prerequisite
***

- JDK 1.8+
- MySQL
- Tomcat 7.0+
- Gradle 3.0+
