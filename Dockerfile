FROM openjdk:8

ADD target/revfoods-backend.jar revfoods-backend.jar

EXPOSE 2020

ENTRYPOINT ["java","-jar","revfoods-backend.jar"]