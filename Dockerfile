FROM maven:3.6.3-jdk-8 As build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:8-jre-slim
COPY --from=build /target/backendecommerce-0.0.1-SNAPSHOT.jar backendecommerce.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","backendecommerce-0.0.1-SNAPSHOT.jar"]