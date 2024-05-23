#  FIAP Tech Challenge | Delivery

### Fase 01 - Tech Challenge | Pós-graduação em Arquitetura de Software

----

## Grupo 15

| Matrícula | Nome                                               | E-mail                                                |
|-----------|----------------------------------------------------|-------------------------------------------------------|
| RM354688  | Nicholas Mateus Barreto Veloso de Azevedo Dantas   | [Enviar E-mail](mailto:nicholas.mateus@gmail.com)     |
| RM354692  | Paulo Ricardo Gonçalves dos Santos                 | [Enviar E-mail](mailto:pricardo.ti@gmail.com)                |
| RM356150  | Tarcisio Dantas de Andrade                         | [Enviar E-mail](mailto:tarcisiodantas_deandrade@hotmail.com) |

---

## Sobre o Projeto ```Delivery```

---

Projeto referente a gestão de pedidos para uma lanchonete.

## Tecnologias Usadas

---

![Java](https://img.shields.io/badge/java_22-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)

## Pré-requisitos do Projeto ```DELIVERY```

---

- ```src/main/java```: Diretório do código fonte da aplicação;
- ```src/main/resources```: Diretório dos recursos da aplicação (configurações, scripts do banco de dados e outros);
- <code>Dockerfile</code>:  Arquivo responsável pelas instruções de criação da imagem **Docker** da aplicação;
- ```docker-compose.yml```: Arquivo responsável pelas configurações de iniciar os serviços do **Docker**.

## Etapas de Configuração e Execução do Projeto **Delivery**

---

### Etapa 01: Instalação do Docker Desktop ou Docker Engine

Para realizar a instalação do docker, devemos selecionar a opção do nosso sistema operacional e a documentação abaixo:

#### DOCKER DESKTOP

- **Windows**
  - [Instalar Docker Desktop para Windows](https://docs.docker.com/desktop/install/windows-install/)
- **MAC**
  - [Instalar Docker Desktop para MAC](https://docs.docker.com/desktop/install/mac-install/)
- **Linux**
  - [Instalar Docker Desktop para Linux](https://docs.docker.com/desktop/install/linux-install/)

#### DOCKER ENGINE

- [Instalar Docker Engine](https://docs.docker.com/engine/install/)

> **Para maiores informações, poderá acessar a documentação do próprio [Docker](https://www.docker.com/get-started/)**

### Etapa 02: Construção e Inicialização das Imagens para Execução dos Serviços via Docker

Para realizar a execução da aplicação, será necessário antes, a construção das imagens para o containers do **Docker**.

Estando com o **Docker Desktop** aberto ou com seu serviço em execução, precisa navegar até o diretório do projeto para executar o comando abaixo:

```docker

docker compose up -d

```

> Lembrando que o parâmetro "-d", vem de "detached mode" ou modo desanexado.
> Para que o docker compose inicie os containers em segundo plano.

O comando supracitado irá criar e iniciar os seguintes containers:

- ```postgres``` - Container responsável pela execução do Banco de Dados Relacional **PostgreSQL**
- ```delivery``` - Container responsável pela execução da aplicação Java **delivery**

## OpenAPI 3.0

---

O acesso a documentação da API REST da aplicação **Delivery**, está disponível no link abaixo:

[Contrato API Delivery - OpenAPI](http://localhost:8080/api/swagger-ui/index.html)



