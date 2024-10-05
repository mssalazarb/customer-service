FROM gradle:8.10.2-jdk21-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src/producer
WORKDIR /home/gradle/src/producer
RUN gradle build --no-daemon --stacktrace -x test

FROM openjdk:21-bullseye
EXPOSE 8084
ARG JAR_FILE=build/libs/*.jar
COPY --from=build /home/gradle/src/producer/build/libs/*.jar /home/app.jar
ENV SPRING_PROFILES_ACTIVE=default
ENV APP_NAME=customer-service
ENV PORT=8084
ENV DB_HOST=localhost
ENV DB_PORT=5432
ENV DB_NAME=customers_service
ENV DB_USER=postgres
ENV DB_PASSWORD=postgres
CMD java -server -Dserver.tomcat.threads.max=200 -Duser.country=EC -Duser.language=es -Duser.timezone=America/Guayaquil -jar /home/app.jar

