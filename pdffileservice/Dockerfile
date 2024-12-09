FROM openjdk:17
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} pdfFileService.jar
ENTRYPOINT ["java", "-jar", "/pdfFileService.jar"]