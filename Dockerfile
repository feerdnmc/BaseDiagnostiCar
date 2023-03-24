FROM amazoncorretto:11
MAINTAINER FID
COPY target/mgb-0.0.1-SNAPSHOT.jar fid-app.jar
ENTRYPOINT ["java","-jar","/fid-app.jar"]
