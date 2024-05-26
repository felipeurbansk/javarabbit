# Use uma imagem base do JDK 11 ou outra versão de sua preferência
FROM openjdk:11-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo JAR para o contêiner
COPY target/myapp.jar myapp.jar

# Expõe a porta da aplicação
EXPOSE 8080
EXPOSE 5432

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "myapp.jar"]