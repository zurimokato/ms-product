FROM openjdk:17-jdk-slim
LABEL authors="noj2304"
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} ms-product.jar
ENTRYPOINT ["java", "-jar","/ms-product.jar"]