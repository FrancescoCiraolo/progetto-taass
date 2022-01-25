FROM openjdk:18-alpine
COPY /target/iina-gateway-*.jar gateway.jar
EXPOSE 8762
CMD ["java", "-jar", "gateway.jar"]