#  FIAP Tech Challenge | Delivery

### Fase 02 - Tech Challenge | Pós-graduação em Arquitetura de Software

----

## Seção 01 - INFORMAÇÕES DO GRUPO E INTEGRANTES

| MATRÍCULA  | NOME                                              | E-MAIL                                                        |  GRUPO  |
|:-----------|:--------------------------------------------------|:--------------------------------------------------------------|:-------:|
| RM354688   | Nicholas Mateus Barreto Veloso de Azevedo Dantas  | [Enviar E-mail](mailto:nicholas.mateus@gmail.com)             |   15    |
| RM354692   | Paulo Ricardo Gonçalves dos Santos                | [Enviar E-mail](mailto:pricardo.ti@gmail.com)                 |   15    |
| RM356150   | Tarcisio Dantas de Andrade                        | [Enviar E-mail](mailto:tarcisiodantas_deandrade@hotmail.com)  |   15    |

## Seção 02 - Arquitetura do Sistema

Na abordagem utilizada para a arquitetura do sistema, foi adotada a _Clean Architecture_ (**Arqutetura Limpa**). Essa arquitetura fornece grandes beneficios como:

- Maintainability 
- Testability 
- Modularity 
- Separation of concerns 
- Loose coupling 
- Dependency inversion 

### Quais cenários ou situações devemos usar ?

Construir aplicações **complexas** ou de **longa duração** onde a **manutenção, a testabilidade e a escalabilidade são cruciais**. _Clean Architecture_ é adequado para projetos onde o modelo de domínio é fundamental para a funcionalidade da aplicação e precisa ser bem definido e encapsulado.

Diagrama da nossa arquitetura:

![Arquitetura App Delivery](./docs/images/arquitetura-aplicacao.svg)

## Seção 03 - INFORMAÇÕES SOBRE O PROJETO

### Sobre o Projeto DELIVERY

Projeto referente a gestão de pedidos para uma lanchonete.

## Tecnologias Usadas

![Java](https://img.shields.io/badge/java_22-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white)
![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

## Etapas de Configuração e Execução do Projeto **Delivery**

Esta documentação oferece diretrizes detalhadas para a configuração do ambiente Minikube, a implantação de aplicativos e o 
acesso a serviços num cluster Kubernetes local. A seguir, você encontrará os procedimentos que descrevem cada uma das 
etapas necessárias:

### Etapa 00: Instalar o Minikube

Para verificar as instruções para instalar o Minikube, basta acessar o seguinte link:

- [Minikube-Install-Windows](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download)
- [Minikube-Install-Linux](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download)
- [Minikube-Install-macOS](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fmacos%2Fx86-64%2Fstable%2Fbinary+download)

### Etapa 01: Habilitar Métricas do Minikube

Para habilitar a coleta de métricas no Minikube, execute os seguintes comandos:

```bash
minikube addons list
minikube addons enable metrics-server
```

### Etapa 02: Iniciar o Minikube

Para iniciar o Minikube, utilize o seguinte comando:

```bash
minikube start
```

### Etapa 03: Utilizar o Daemon Docker dentro da Instância do Minikube

Para configurar o uso do daemon Docker dentro da instância do Minikube, execute o seguinte comando:

```bash
eval $(minikube docker-env)
```

### Etapa 04: Gerar a Imagem do Projeto

Para construir a imagem do projeto no diretório do projeto, utilize o seguinte comando:

```bash
docker build --no-cache -t delivery .
```

### Etapa 05: Executar os Scripts de Implantação

Para implantar os recursos necessários no Kubernetes, execute os seguintes comandos:

```bash
kubectl apply -f k8s/postgres-configmap-1.yml
kubectl apply -f k8s/postgres-pvc-pv-2.yml
kubectl apply -f k8s/postgres-deployment-3.yml
kubectl apply -f k8s/postgres-service-4.yml
kubectl apply -f k8s/delivery-configmap-5.yml
kubectl apply -f k8s/delivery-deployment-6.yml
kubectl apply -f k8s/delivery-service-7.yml
kubectl apply -f k8s/delivery-hpa.yml
```

### Etapa 06: Conectar o DBeaver ao PostgreSQL

Para conectar o DBeaver ao PostgreSQL implantado no Kubernetes, execute os seguintes comandos:

```bash
kubectl get pods
kubectl port-forward pod/[pod-name] 5432:5432
```

Após isso, conecte o DBeaver à seguinte URL:

```
localhost:5432/postgres
```

Use as seguintes credenciais:

- Usuário: fiap
- Senha: fiap123

### Etapa 07: Expor a Porta 80 do Container da Aplicação

Para acessar a aplicação via porta 8080, execute o seguinte comando:

```bash
kubectl port-forward pod/[pod-name] 8080:8080
```

Após isso, você pode acessar a seguinte URL para acessar a API de combos:

```bash
localhost:8080/v1/clientes
```

### Etapa 08: Encerrar o Minikube

Para encerrar o Minikube, utilize o seguinte comando:

```bash
minikube stop
```

Após isso, você pode excluir os containers:

```bash
minikube delete all --all
```

## Swagger

O acesso a documentação da API REST da aplicação **Delivery**, está disponível no link abaixo:

```html
https://pricardoti.github.io/architecture-software-tech-challenge-fiap/
```

> Para acessar as informações do contrato da API Rest do **Delivery**, será necessário que a aplicação esteja
> em execução.
 
 
## Collection Postman / Insomnia

Para baixar a collection da [API Delivery](./docs/collections/DeliveryAPI.postman_collection_v1.json)

Para acesar e baixar a collection no [Postman](https://documenter.getpostman.com/view/9810786/2sA3QwbVKY)
