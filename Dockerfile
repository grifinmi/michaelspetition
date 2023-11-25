FROM tomcat:latest
ADD target/michaelspetitions.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]
