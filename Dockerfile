# Use Maven with Java 21 to build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn package

# Use Java 21 for runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/computers-shop-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "app.jar"]

