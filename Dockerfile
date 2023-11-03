FROM amazoncorretto:17.0.9
WORKDIR /MentionsBot
COPY build/libs/MentionsBot-1.1.0.jar /MentionsBot
ENTRYPOINT exec java -jar MentionsBot-1.1.0.jar
