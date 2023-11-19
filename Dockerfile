FROM eclipse-temurin:11
LABEL authors="gh.k"

WORKDIR /app
COPY ./build/libs/demo-board-0.0.1-SNAPSHOT.jar /app/demo-board.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-board.jar"]