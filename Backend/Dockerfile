FROM maven:3.5.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:23-slim-bullseye
COPY --from=build /target/cineview-0.0.1-SNAPSHOT.jar cineview.jar
EXPOSE 8080
ENTRYPOINT ["jar" ,"-jar" ,"cineview.jar" ]