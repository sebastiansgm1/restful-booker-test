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

## Stack tecnologico

* Version de Java: 8
* Gestor de paquetes: Gradle
* Serenity framework + Cucumber
* Arnes de pruebas: Junit
* Patrón de automatizacion: Action class

## Instalación y preparación de ambiente

* Use el comando git clone para clonar el proyecto
* Se recomienda usar IntelliJ para abrir el proyecto, tambien puede utulizar un IDE similar como eclipse o vs code
* Si desea compilar el proyecto manualmente use el comando gradle compileJava
* Para correr las pruebas en el proyecto use el comando Gradle clean test

