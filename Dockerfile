FROM openjdk:17.0.2-jdk
LABEL maintainer="arslanibragimov"
VOLUME /fracfixme
# Скопируйте JAR файл в образ
ADD target/FracFixMe-0.0.1-SNAPSHOT.jar FracFixMe-0.0.1-SNAPSHOT.jar
EXPOSE  8080
ENTRYPOINT ["java", "-jar","/FracFixMe-0.0.1-SNAPSHOT.jar"]