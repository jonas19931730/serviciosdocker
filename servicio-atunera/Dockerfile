FROM openjdk:11
VOLUME /tmp
EXPOSE 9001
ADD ./target/servicio-atunera-0.0.1-SNAPSHOT.jar servicio-atunera.jar
ENTRYPOINT ["java","-jar","/servicio-atunera.jar"]
