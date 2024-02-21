FROM openjdk:17
EXPOSE 8080
ADD target/fibonacci.jar fibonacci.jar
ENTRYPOINT ["java", "-jar", "/fibonacci.jar"]