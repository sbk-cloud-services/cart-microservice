FROM maven:3.6.3-jdk-11

COPY pom.xml /service/pom.xml
COPY src/ /service/src

WORKDIR /service/

RUN mvn install

EXPOSE 8080

ENTRYPOINT ["mvn", "spring-boot:run"]