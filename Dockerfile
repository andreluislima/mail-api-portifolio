# Etapa 1: usa Maven para buildar o projeto dentro do container
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: cria imagem final só com o JAR gerado
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/api-form-email-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
