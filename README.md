# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.3/gradle-plugin/packaging-oci-image.html)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.3/reference/web/servlet.html)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Starting this instance
Run this command:
`./gradlew bootRun`

Spring Boot instance will boot up and bootRun will show as executing when it's ready

### Setup Mysql container

* For port forwarding:
`docker run -d --name test-mysql -e MYSQL_ROOT_PASSWORD=abc123 -p 3307:3306 mysql`
* For no port forwarding:
`docker run --name test-mysql -e MYSQL_ROOT_PASSWORD=[pick something, but remember it] -d mysql`

#### Accessing Mysql container

```
docker exec -it container_name bash
mysql -uroot -p
```

#### Accessing Mysql instance directly from local

```
mysql --host=127.0.0.1 --port=3307 -u root -p
```
