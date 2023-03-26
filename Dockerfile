FROM amazoncorretto:17-alpine
WORKDIR /application
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT [ "java","-jar","application.jar" ] 