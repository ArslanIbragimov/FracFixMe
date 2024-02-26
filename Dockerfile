FROM openjdk:17.0.2-jdk
LABEL maintainer="arslanibragimov"
VOLUME /fracfixme
# Скопируйте JAR файл в образ
ADD target/FracFixMe-1.0.1.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]