FROM openjdk:17-jdk-alpine

EXPOSE 8080

COPY target/springbootapp-0.0.1-SNAPSHOT.jar myapp.jar

CMD ["java", "-jar", "myapp.jar"]