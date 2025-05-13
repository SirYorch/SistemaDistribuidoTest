FROM eclipse-temurin:17-jdk

# Crear usuario wildfly
RUN useradd -m -d /home/wildfly wildfly

# Copiar tu instalación local de WildFly
COPY wildfly-36.0.0.Final /opt/wildfly


COPY solicitudes/target/solicitudes-1.0-SNAPSHOT.war /opt/wildfly/standalone/deployments/
COPY wildfly-36.0.0.Final/standalone/configuration/standalone.xml /opt/wildfly/standalone/configuration/

# Hacerlo ejecutable
RUN chmod +x /opt/wildfly/bin/standalone.sh

# Exponer el puerto del servidor
EXPOSE 8080

# Ejecutar WildFly al iniciar
CMD ["/opt/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]