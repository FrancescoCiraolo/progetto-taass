FROM openjdk:18-alpine
COPY /target/iina-events-*.jar events.jar
EXPOSE 8031
CMD ["java", "-jar", "events.jar"]