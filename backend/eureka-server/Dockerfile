FROM openjdk:18-alpine
COPY /target/iina-eureka-server-*.jar discovery.jar
EXPOSE 8761
CMD ["java", "-jar", "discovery.jar"]