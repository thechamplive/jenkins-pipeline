FROM openjdk:17
EXPOSE 8080
ADD target/jenkins-pipeline-docker.jar jenkins-pipeline-docker.jar
ENTRYPOINT ["java", "-jar", "/jenkins-pipeline-docker.jar"]