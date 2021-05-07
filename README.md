# GAME OF THREE
This project is an implementation of a *Game of Three* player. It is written with Java 8
and Spring Boot framework. 

The interaction happens between two players. A player can challenge any other players, unless
the opponent is offline. The communication between two players is handled on a REST API. 

## Running Instructions
The requirements to run an instance, one should have
* Java 8 SDK
* Maven

installed on their machines.

One can run an instance easily by running the command below at the root folder.
```
mvn spring-boot:run 
```
This command will build and run an instance on a random port locally.

## Playing The Game
In order to start a game two players(i.e. instances) should be up. e.g. One have two instances up on 50000 and 60000 
ports. 

With a `POST` request like 
```
{
    "opponent": "localhost:60000",
    "inputType": "AUTO"
}
```
on `localhost:50000/game/challenge` will start a game between these players.
As it is mentioned above, `inputType` can be `AUTO` or `MANUAL`. If it is `AUTO`, challenger picks a random number 
between 0 and 100000. If it is `MANUAL` it should be provided in that request, e.g.
```
{
    "opponent": "localhost:60000",
    "inputType": "MANUAL",
    "number": "56"
}
```
While game continues, each move players make is logged.