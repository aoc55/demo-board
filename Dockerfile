FROM eclipse-temurin:17
LABEL authors="gh.k"

COPY ./build/libs/demo-board-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]