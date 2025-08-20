# Use uma imagem Java 17 leve
FROM eclipse-temurin:17-jre-jammy
LABEL authors="labsfiap"

# Cria diretório da aplicação
WORKDIR /app

# Copia o jar compilado para dentro do container
COPY mix-mercado/target/*.jar /app/app.jar


# Expõe a porta do Spring Boot
EXPOSE 8082

# Comando para rodar a aplicação usando a variável PORT do Render
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8082} -jar /app/app.jar"]
