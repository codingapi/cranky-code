FROM openjdk:17-jdk
WORKDIR /opt/server/
COPY monitor.jar /opt/server/monitor.jar
CMD ["java", "-jar", "/opt/server/monitor.jar"]