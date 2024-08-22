FROM eclipse-temurin:17
LABEL authors="aoc55"

ENV USE_PROFILE     local
ENV DB_URL          mariadb
ENV DB_PORT         3306
ENV DB_USERNAME     demo-board
ENV DB_PASSWORD     board1234

COPY ./build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTIONS -Dspring.profiles.active=${USE_PROFILE} -jar /app.jar"]
