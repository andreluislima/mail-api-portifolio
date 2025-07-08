# Imagem base com Java 17
FROM eclipse-temurin:17-jdk-alpine

# Define o diretório dentro do container
WORKDIR /app

# Copia o .jar do projeto local para o container
COPY target/api-form-email-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Comando para iniciar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
