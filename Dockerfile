# Use an official OpenJDK base image
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file built by Maven into the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your Spring Boot app listens on
EXPOSE 8080

# Run the Spring Boot application when the container starts
CMD ["java", "-jar", "app.jar"]
