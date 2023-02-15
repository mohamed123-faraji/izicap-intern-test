
FROM openjdk:10-jre-slim

WORKDIR /app
COPY ./target/izicap-intern-test.jar /app

EXPOSE 8080

CMD ["java", "-jar", "izicap-intern-test.jar"]