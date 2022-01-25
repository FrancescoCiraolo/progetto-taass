FROM openjdk:18-alpine
COPY /target/iina-users-*.jar users.jar
EXPOSE 8001
CMD ["java", "-jar", "users.jar"]