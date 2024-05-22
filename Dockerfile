FROM gradle:8.7.0-jdk17-alpine

COPY . .

RUN gradle build

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "build/libs/LaFloridita-0.0.1-SNAPSHOT.jar"]