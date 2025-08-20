FROM openjdk:17-jdk-slim
LABEL authors="labsfiap"

# Copia o jar para o container
COPY app.jar /app.jar

# Expõe a porta (opcional, mas bom para documentação)
EXPOSE 8082

# Comando para rodar o app
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8082} -jar /app.jar"]

