FROM openjdk:17-alpine
RUN apk add --no-cache bash
COPY target/docker-test-0.0.1-SNAPSHOT.jar docker-test.jar
COPY wait-for-it.sh /wait-for-it.sh
RUN chmod +x /wait-for-it.sh
CMD ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "docker-test.jar", "--spring.profiles.active=docker"]

