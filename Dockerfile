FROM openjdk:17
EXPOSE 5500
ADD target/ROOT.jar ROOT.jar
CMD ["java", "-jar", "ROOT.jar"]