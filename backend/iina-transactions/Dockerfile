FROM openjdk:18-alpine
COPY /target/iina-transactions-*.jar transactions.jar
EXPOSE 8011
CMD ["java", "-jar", "transactions.jar"]