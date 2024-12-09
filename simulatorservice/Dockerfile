FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} SimulatorService.jar
ENTRYPOINT ["java", "-jar", "/SimulatorService.jar"]