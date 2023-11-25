FROM tomcat:latest
ADD target/michaelspetition.war /usr/local/tomcat/webapps/
EXPOSE 8081
CMD ["catalina.sh", "run"]
