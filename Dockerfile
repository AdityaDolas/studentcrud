FROM openjdk:latest
ADD target/user-mysql.jar user-mysql.jar
ENTRYPOINT ["java", "-jar", "user-mysql.jar"]
EXPOSE 8080