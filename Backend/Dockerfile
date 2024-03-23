FROM maven:3.9.5-openjdk-21 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-slim-bullseye
COPY --from=build /target/cineview-0.0.1-SNAPSHOT.jar cineview.jar
EXPOSE 8080
ENTRYPOINT ["jar" ,"-jar" ,"cineview.jar" ]