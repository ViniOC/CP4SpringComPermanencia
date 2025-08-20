FROM ubuntu:latest
LABEL authors="labsfiap"

ENTRYPOINT ["top", "-b"]
CMD ["sh","-c","java -Dserver.port=${PORT:-8082} -jar app.jar"]
