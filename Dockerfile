FROM openjdk:8-jdk-alpine
EXPOSE 9090
ADD target/BoottomLineAssignment.jar BoottomLineAssignment.jar
ENTRYPOINT ["java","-jar","BoottomLineAssignment.jar"]