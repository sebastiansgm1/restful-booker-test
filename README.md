# Proyecto de automatizacion de pruebas de API YAPE
Este es el reto de automatización de pruebas de API de YAPE

## Autor: Sebastian Galeano Molina / Senior QA Automation
Las pruebas estan orientadas a las API de reserva RESTFUL - BOOKER

## Especificaciones de pruebas

* Se plantearon varios flujos que pudieran cubrir los servicios disponibles del API
* Para efectos de mostrar diferentes implementaciones, se crearon diferentes tipos de pruebas, desde validaciones
tecnicas como codigo de respuesta y contrato, hasta flujos funcionales mediante escenarios BDD
* Los flujos cortos se plantearon como pruebas BDD simples
* Los flujos mas completos se estructuraron usando lenguaje Gherkin
* Variando la data se cubren escenarios unHappyPath (DataDriven)
* El proyecto tambien tiene diferentes formas de lectura de data y tipos de escenarios
como tablas, escenarios outline y pruebas simples parametrizables

## Plan de pruebas
Se plantean varias pruebas con el fin de lograr una buena cobertura, las pruebas planteadas son:
* Prueba basica de validación de salud de las APIS
* Prueba basica de validación de consulta de listado de APIS
* Prueba basica de validación del servicio de autenticación
* Flujo E2E de creación de una reservación, incluye prueba de los servicios de creación y consulta, consulta de lista de reservaciones, pruebas de contrato y codigo de respuesta
* Flujo E2E de actualización de una reservación, incluye prueba de los servicios de consulta, creación, autenticación y actualización, pruebas de contrato y codigo de respuesta
* Flujo E2E de la actualización parcial de una reservación, incluye prueba de los servicios de consulta, creación, autenticación y actualización parcial, pruebas de contrato y codigo de respuesta
* Flujo E2E de eliminación de una reservación, incluye prueba de los servicios de creación y consulta (Cuando no se encuentra la reservación), autenticación y eliminación, pruebas de contrato y codigo de respuesta

## Stack tecnologico

* Version de Java: 8
* Gestor de paquetes: Gradle
* Serenity framework + Cucumber
* Arnes de pruebas: Junit
* Patrón de automatizacion: Action class

## Instalación y preparación de ambiente

* Use el comando `git clone https://github.com/sebastiansgm1/restful-booker-test` para clonar el proyecto
* Se recomienda usar IntelliJ para abrir el proyecto, tambien puede utulizar un IDE similar como eclipse o vs code
* Si desea compilar el proyecto manualmente use el comando gradle compileJava
* Para correr las pruebas en el proyecto use el comando Gradle clean test

## Documentación de apoyo
- **Serenity**: https://serenity-bdd.github.io/docs/tutorials/first_test
- **Gradle**: https://docs.gradle.org/current/userguide/userguide.html
- **Selenium**: https://www.selenium.dev/documentation/webdriver/
- **Xpath**: https://www.w3schools.com/xml/xpath_syntax.asp
- **Cucumber**: https://cucumber.io/docs/cucumber/
- **Appium**: https://appium.io/docs/en/about-appium/api/

## Ejecución de pruebas en Github Action (CI)

Este proyecto esta parametrizado para ejecutarse en github actions, el disparador del
actions es cuando se hace push a la rama principal o se realiza un pull request,
puede ver las ejecuciones en la pestaña actions en el repositorio github

https://github.com/sebastiansgm1/restful-booker-test/actions 

