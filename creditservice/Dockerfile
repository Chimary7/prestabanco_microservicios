FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} creditService.jar
ENTRYPOINT ["java", "-jar", "/creditService.jar"]