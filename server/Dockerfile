# Build Stage
FROM gradle:8.14.2-jdk24 AS build
LABEL MAINTAINER="srijaadhya.11sc.2020@gmail.com"
COPY service /home/gradle/service
WORKDIR /home/gradle/service
RUN gradle bootJar --no-daemon

# Runtime Stage
FROM amazoncorretto:24-alpine3.21-jdk
WORKDIR /app
EXPOSE 8080

# Health Check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
  CMD curl -f http://localhost:8080/health || exit 1
COPY --from=build /home/gradle/service/build/libs/*.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]