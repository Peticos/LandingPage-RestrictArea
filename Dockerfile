FROM tomcat:9-jdk11

# Copie seu arquivo .war para o diretório webapps do Tomcat
COPY target/Peticos-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

# Exponha a porta padrão do Tomcat
EXPOSE 8080

# Inicie o Tomcat
CMD ["catalina.sh", "run"]
