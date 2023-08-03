FROM openjdk:17-jdk
WORKDIR /opt/server/
COPY server.jar /opt/server/server.jar
CMD ["java", "-jar", "/opt/server/server.jar"]