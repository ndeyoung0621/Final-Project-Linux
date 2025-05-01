FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY final-team-project-team-tetris/ ./final-team-project-team-tetris
WORKDIR /app/final-team-project-team-tetris
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/final-team-project-team-tetris/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]