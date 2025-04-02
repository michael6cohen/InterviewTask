FROM openjdk:17-jdk-slim
LABEL author="Michal Cohen"

ARG JAR_FILE=target/InterviewTask-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]