FROM openjdk:11
VOLUME /tmp
EXPOSE 8091
ADD ./target/servicio-enlace-middleware-0.0.1-SNAPSHOT.jar servicio-enlace.jar
ENTRYPOINT ["java","-jar","/servicio-enlace.jar"]
