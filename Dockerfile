FROM maven:3-eclipse-temurin-22-alpine AS build

WORKDIR /app
COPY . .

RUN mvn clean package -f pom.xml -DskipTests

FROM amazoncorretto:22-jdk

COPY --from=build /app/target/*.jar /delivery.jar
CMD apt-get update -y

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/delivery.jar"]