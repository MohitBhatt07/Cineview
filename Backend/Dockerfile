FROM maven:3.8.1-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /target/cineview-0.0.1-SNAPSHOT.jar cineview.jar
EXPOSE 8080
ENTRYPOINT ["jar" ,"-jar" ,"cineview.jar" ]