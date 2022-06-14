FROM openjdk:11
VOLUME /tmp
EXPOSE 9004
ADD ./target/servicio-auth-0.0.1-SNAPSHOT.jar servicio-auth.jar
ENTRYPOINT ["java","-jar","/servicio-auth.jar"]
