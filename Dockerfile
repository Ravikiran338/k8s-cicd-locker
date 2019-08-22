FROM openjdk:8
MAINTAINER Radiant Digital
ADD target/*.jar /msa-locker-service.jar
RUN bash -c 'touch /msa-locker-service.jar'
CMD ["java","-Dspring.profiles.active=docker","-jar","/msa-locker-service.jar"]
EXPOSE 9083
