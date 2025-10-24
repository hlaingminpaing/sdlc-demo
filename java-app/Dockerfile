FROM openjdk:17-jdk-slim
WORKDIR /app
COPY . .
RUN ./mvnw package -DskipTests || true
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "target/demo-1.0.0.jar"]
