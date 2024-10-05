FROM gradle:8.10.2-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradel/src/producer
WORKDIR /home/gradle/src/producer
RUN gradle build --no-daemon --stacktrace -x test

FROM openjdk:21-bullseye
EXPOSE 8084
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/producer/build/libs/*.jar /home/app.jar
CMD java -server -Dserver.tomcat.threads.max=200 -Duser.country=EC -Duser.language=es -Duser.timezone=America/Guayaquil -jar /home/app.jar

