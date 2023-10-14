FROM maven:3.8.3-openjdk-17 As build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /Users/mrunaleepatel/seir-kale/Projects/Final/backendecommerce/target/backendecommerce-0.0.1-SNAPSHOT.jar
/target/backendecommerce-0.0.1-SNAPSHOT.jar
EXPOSE ${PORT}
ENTRYPOINT ["java","-jar","/target/backendecommerce-0.0.1-SNAPSHOT.jar"]