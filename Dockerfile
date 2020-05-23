FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} rental-service.jar
ENTRYPOINT ["java","-jar","/rental-service.jar"]
EXPOSE 5555

