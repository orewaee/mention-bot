FROM gradle:latest AS BUILD
WORKDIR /app
COPY . .
RUN gradle clean
RUN gradle shadowJar

FROM amazoncorretto:17.0.9
ENV APP_HOME=/app
ENV JAR_NAME=MentionsBot-1.1.0.jar
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME
