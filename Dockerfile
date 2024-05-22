FROM maven:3.9.6-eclipse-temurin-22-alpine AS builder

WORKDIR /home/maven/src

COPY pom.xml /home/maven/src/
COPY src/main/resources /home/maven/src/src/main/resources

RUN mvn dependency:go-offline

COPY src /home/maven/src/src

RUN mvn clean install -DskipTests

FROM amazoncorretto:22-alpine

WORKDIR /app

COPY --from=builder /home/maven/src/target/delivery-*.jar /app/tech-challenge-delivery.jar
COPY src/main/resources /app/resources

CMD ["java", "-jar", "tech-challenge-delivery.jar"]