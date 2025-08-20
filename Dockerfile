# Stage 1: Build Maven
FROM maven:3.9.3-eclipse-temurin-17 AS build
WORKDIR /app
COPY mix-mercado/pom.xml .
COPY mix-mercado/src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar /app/app.jar
EXPOSE 8082
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8082} -jar /app/app.jar"]
