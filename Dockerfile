FROM maven:3.9.4-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /home/app/target/backendecommerce-0.0.1-SNAPSHOT.jar /usr/app/backendecommerce-0.0.1-SNAPSHOT.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","backendecommerce.jar"]