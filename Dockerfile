FROM khipu/openjdk17-alpine:latest
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline
RUN ./mvnw package -DskipTests
EXPOSE 8080
CMD ["java", "-jar", "target/ecommerce_api-1.0.0.jar"]
RUN adduser -D 10001
USER 10001
