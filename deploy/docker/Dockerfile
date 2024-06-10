FROM openjdk:17-slim
ARG JAR_FILE=../../build/*.jar
COPY ${JAR_FILE} medical-care-service-${version}.jar
ENTRYPOINT ["java","-jar","/medical-care-service-$version.jar"]