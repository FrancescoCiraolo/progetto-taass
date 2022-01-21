FROM openjdk:18-alpine
COPY /target/iina-dashboards-*.jar dashboards.jar
EXPOSE 8021
CMD ["java", "-jar", "dashboards.jar"]