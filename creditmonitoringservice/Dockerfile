FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} creditMonitoringService.jar
ENTRYPOINT ["java", "-jar", "/creditMonitoringService.jar"]