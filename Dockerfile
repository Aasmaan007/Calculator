# Use OpenJDK 11 as the base image
FROM openjdk:11

# Copy the built JAR file from the target directory to the container's working directory
COPY ./target/Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar ./Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar

# Set the working directory (this is optional but makes things cleaner)
WORKDIR ./

# Command to run the application
CMD ["java", "-cp", "Calculator-1.0-SNAPSHOT-jar-with-dependencies.jar", "org.example.Main"]
