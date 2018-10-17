FROM openjdk:8
ADD target/hello-spring-fu-0.0.1-SNAPSHOT.jar /usr/src/spring-fu/hello-spring-fu.jar
WORKDIR /usr/src/spring-fu
CMD java -Xdebug -Xrunjdwp:server=y,transport=dt_socket,address=5005,suspend=n -jar hello-spring-fu.jar
EXPOSE 8080 5005
