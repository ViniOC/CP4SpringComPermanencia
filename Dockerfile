FROM ubuntu:latest
LABEL authors="labsfiap"

ENTRYPOINT ["top", "-b"]