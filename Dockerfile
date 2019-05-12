FROM openjdk:8-jdk-alpine
LABEL maintainer="daniel.menezes@leapmind.com.br"
ARG JAR_FILE=target/matrix-1.0.0.jar
ADD ${JAR_FILE} matrix.jar
ENTRYPOINT [ "java","-Xmx1024m","-jar","matrix.jar"]
