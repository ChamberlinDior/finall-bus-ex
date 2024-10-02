FROM ubuntu:latest
LABEL authors="tradi"

ENTRYPOINT ["top", "-b"]