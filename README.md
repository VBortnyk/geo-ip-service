# GepIP service
#### Table of Contents
* [Project purpose](#purpose)
* [Project structure](#structure)
* [For developer](#developer-start)
* [Author](#author)
#
#### <a name="purpose">Project purpose</a>
The aim of this project is to help users get brief geographical data of a location, 
related to the IP address available. Everything should be done is to input a canonical representation of
IP address available, and the information will be displayed on the screen. If the IP address is incorrect or is not in the database
empty Json object will be returned.
#
#### <a name="purpose">Project structure</a>
This is a Spring Boot project, and the main modules where configured by:
* Spring Bot Dev Tools
* Lombok library
* Spring WEB
* Spring Data JPA
* MySQL Driver

Following dependencies where added manually:
* OpenCSV 2.3
* Log4j 1.2.17
#
#### <a name="purpose">For developers</a>
1. Open the project in your IDE.
2. Choose sdk 11.0  or higher in Project Structure.
3. Start MySQLWorkbench
   * Create a new connection
   * Database is available at IP: 34.89.185.132, user: root, password: mate2020
4. You can create an alternative database using data from https://lite.ip2location.com/database/ip-country-region-city-latitude-longitude 
   and inject it with ma.geoipservice.controller.injectController.
5. Change a path to log file in ma.goeipservice.src.main.resources.log4j.properties.
6. Run the project.

As this is a trial version, only 100_000 IP addresses(within the range of 16777216(1.0.0.0) and 18134783(1.20.182.255))
are stored in the database.
#

#### Author
Viacheslav Bortnyk: https://github.com/VBortnyk/geo-ip-service

