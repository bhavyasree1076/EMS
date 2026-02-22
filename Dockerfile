FROM tomcat:10.1-jdk17
COPY _employee_management_system.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]
