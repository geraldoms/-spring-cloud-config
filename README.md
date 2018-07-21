# Spring Cloud Config

This is a very basic example using Config Server from Spring Cloud.
It has basically three modules:

* [Config-client module](https://github.com/geraldoms/spring-cloud-config/tree/master/config-client): 
 This module contains a simple client that access its configs on the Config-server through the service discovery.
 
* [Discovery-server module](https://github.com/geraldoms/spring-cloud-config/tree/master/discovery-server):
This module contains the service discovery to keep the info to access the Config-server.

* [Config-server module](https://github.com/geraldoms/spring-cloud-config/tree/master/config-server): 
This module contains the Config-server that centralized the configs on the system.

The order to run the services matters. The first one must be the Discovery-server, followed by Config-server and the Config-client.  
After that, the Config-Server will register in the Discovery-server (See the `http://localhost:8761`).

## Requirements
* JDK 8 or later
* Maven 3.2+

## Installation 
`$ mvn package`

## Usage 

After running the command above (in the installation section), you can start the application by running (in the follow order):   
 
 1. `java -jar discovery-server/target/discovery-server-0.0.1-SNAPSHOT.jar`;
 2. `java -jar config-server/target/config-server-0.0.1-SNAPSHOT.jar`;
 3. `java -jar config-client/target/config-client-0.0.1-SNAPSHOT.jar`;


The endpoint to get the configs from the Config-client is: `http://localhost:8082/configs`.

## Request samples

Since it's using the `getNextServerFromEureka`, the next server will be picked on a round-robin fashion. 

Request:
```bash
 curl http://localhost:8082/configs
```
Response:
```
Properties: [Property value version 3 || Other property value version 3].
```