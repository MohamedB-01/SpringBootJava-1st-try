FROM openjdk:8
EXPOSE 8085
ADD target/p1-0.0.1-SNAPSHOT.jar project1.jar
ENTRYPOINT [ "java" , "-jar" , "/project1.jar"]