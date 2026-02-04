# Projeto Kafka Expert

Este projeto recebe um JSON com dados de usuário via Kafka, processa usando arquitetura hexagonal em Java com Spring Boot, e publica o resultado em outro tópico.

## Requisitos
- Java 17+
- Maven 3+
- Kafka em execução

## Como rodar

```bash
mvn spring-boot:run
```

## Configuração

Veja `src/main/resources/application.yml` para tópicos e bootstrap servers.
