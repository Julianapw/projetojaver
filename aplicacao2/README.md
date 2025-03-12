# 🏦 Projeto Final - Gerenciamento de Clientes do Banco JAVER  

![Java](https://img.shields.io/badge/Java-17-blue?style=flat-square&logo=java)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.0-green?style=flat-square&logo=springboot)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=flat-square&logo=mysql)  
![Postman](https://img.shields.io/badge/Postman-Test-orange?style=flat-square&logo=postman)  

Este projeto é um sistema de gerenciamento de clientes do **Banco JAVER**, desenvolvido com **Spring Boot**. Ele permite realizar operações **CRUD** e calcular o score de crédito dos clientes de forma eficiente e escalável.  

---

## ✨ Funcionalidades  
✔️ **Gerenciamento de Clientes**  
- Nome  
- Telefone  
- Status de Correntista (Sim/Não)  
- Score de Crédito  
- Saldo em Conta Corrente  

✔️ **Cálculo de Score de Crédito**  
- Fórmula: `score_credito = saldo_cc * 0,1`  

✔️ **Arquitetura em Microserviços**  
- Aplicação 1: Gerencia as requisições do cliente e interage com a Aplicação 2.  
- Aplicação 2: Responsável por armazenar os dados no banco e executar as operações CRUD.  
---
## 🛠️ Tecnologias Utilizadas  
- **Java 17** ☕  
- **Spring Boot** 🚀  
- **MySQL** 🐬  
- **H2 Database** (em memória) 🛢️  
- **Postman** (para testes) 🧪  
---
## 🚀 Como executar  

 **Clonar o repositório**
git clone https://github.com/Julianapw/projetofinal.git
cd projetofinal  
**Configurar o Banco de Dados**
- Insira as credenciais do banco MySQL no arquivo application.properties localizado em cada aplicação.
- Caso prefira, utilize o H2 Database como alternativa para testes.  
**Executar as Aplicações**
- Para executar cada aplicação, utilize o comando abaixo dentro do diretório da aplicação correspondente:
./mvnw spring-boot:run
**Testar com o Postman**
- Configure e importe a coleção de endpoints disponível no repositório.
- Realize operações CRUD e testes de cálculo de score.
