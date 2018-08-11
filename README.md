
# Load Balancer v1.00
> A simulation of a load balancing system.


## Development configuration

### Prerequisite
To test this project, it is essential to have the basics of object-oriented programming and java language.

### Compile and Run
#### Windows:
```sh
loadbalancer.bat
```
#### Linux and Mac OS
```sh
loadbalancer.sh
```
## Main objective

The goal of this practical work is to become familiar with JAVA's features regarding threads synchronization and communication between processes via sockets. It involves simulating a load balancer connected to n servers and which sends them requests from k clients, according to the Round Robin algorithm.
The technologies used in this project are: [les threads](https://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html), [les runnables](https://docs.oracle.com/javase/7/docs/api/java/lang/Runnable.html) and [sockets](https://docs.oracle.com/javase/7/docs/api/java/net/Socket.html).


## Classes

The following table describes all the classes in this project.

|Classes    |Description          |
|-----------|---------------------|
|EchoClient | Represents a client of the system. A client connects to the load balancer and asks for the solution of a mathematical equation (ex: addition of two numbers).
|Serveur| Represents a server connected to the loadbalancer. A server receives a mathematical equation and returns the solution to the loadbalancer.
| Probleme | Represents a mathematical problem. This class offers two methods: generate (): generates a simple mathematical equation. calculate (equation): solves a mathematical equation and return the solution.
| Loadbalancer | Represents the interface between servers and clients. He receives requests from clients and by applying Round Robin he chooses a server to execute the customer's request. He is also responsible for returning the values to the clients.|


## Contribution
This project is carried out as part of a practical work in class. He was supervised by Dr. Mariem Lahami.

### Authors:
 - Dhiaeddine LOGHMARI
 - Wael Latiri
### Licence
This project is licensed under the MIT License.
