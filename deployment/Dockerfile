FROM gradle:5.6.2-jdk8
VOLUME /tmp
ADD weather-0.0.1.jar app.jar
ENTRYPOINT ["java","-Dspring.profiles.active=docker","-jar","app.jar"]