FROM openjdk:17
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
ARG JAR_FILE=./build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["./wait-for-it.sh", "database-mysql:3306", "--", "java", "-jar", "app.jar"]