FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/MsTiendas-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8030
ENTRYPOINT ["java", "-jar", "app.jar"]
