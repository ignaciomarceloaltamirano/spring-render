FROM openjdk:17-jdk-alpine
COPY target/spring_mysql.jar java-app.jar
ENTRYPOINT ["java", "-jar","java-app.jar"]