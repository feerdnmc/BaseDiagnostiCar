FROM amazoncorretto:11-alpine-jdk
MAINTAINER FID
COPY target/mgb-0.0.1-SNAPSHOT.jar fid-app.jar
ENTRYPOINT ["java","-jar","/fid-app.jar"]
