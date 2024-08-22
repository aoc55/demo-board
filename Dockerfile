FROM eclipse-temurin:17
LABEL authors="aoc55"

ENV USE_PROFILE        local
ENV A
# ENV
COPY ./build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTIONS -Dspring.profiles.active=${USE_PROFILE} -jar /app.jar"]
