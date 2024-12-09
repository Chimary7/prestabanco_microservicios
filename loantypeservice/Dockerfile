FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} LoanTypeService.jar
ENTRYPOINT ["java", "-jar", "/LoanTypeService.jar"]