FROM openjdk:17-slim

ARG JAR_VERSION
ENTRYPOINT ["/bin/sh", "-c", "java -jar /app/build/libs/medical-care-service-${JAR_VERSION}.jar"]