#FROM adoptopenjdk/openjdk11:jre-11.0.19_7-ubuntu
#ADD target/eca-apartment-catalog-*.jar app.jar
#ENV JAVA_OPTS=""
#ENV APP_NAME="ecaapartmentcatalog"
#ENV SECURITY_OPTS="-Djava.security.egd=file:/dev/./urandom"
#
#COPY entrypoint.sh ./
#RUN chmod 755 ./entrypoint.sh
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


FROM openjdk:17-alpine
ADD target/hotel-reservation-api-*.war app.war
ENTRYPOINT ["java","-jar","app.war"]