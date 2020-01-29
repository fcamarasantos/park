### FCamara Hackathon FC 🚀
*"Queremos ser como uma árvore, 
  crescer um pouco todos os dias e tentar tocar o céu, 
  sem perder a solidez de nossas raízes."*

Criar um sistema para gerenciar um estacionamento de carros e motos.

## Cadastro de estabelecimento

Criar um cadastro da empresa com os seguintes campos:
- Nome;
- CNPJ;
- Endereço;
- Telefone;
- Quantidade de vagas para motos;
- Quantidade de vagas para carros.

**Todos** os campos são de preenchimento obrigatório.

## Cadastro de veículos

Criar um cadastro de veículos com os seguintes campos:
- Marca;
- Modelo;
- Cor;
- Placa;
- Tipo.

**Todos** os campos são de preenchimento obrigatório.

## Funcionalidades

   - **Estabelecimento:** CRUD;
   - **Veículos:** CRUD;
   - **Controle de entrada e saída de veículos.**

## Requisitos

   - Modelagem de dados;
   - O retorno deverá ser em formato JSON e XML;
   - Requisições GET, POST, PUT ou DELETE, conforme a melhor prática;
   - A persistência dos dados pode ser realizada da maneira que preferir;
   - Criar README do projeto descrevendo as tecnologias utilizadas, chamadas dos serviços e configurações necessário para executar a aplicação.
   
## Ganha mais pontos
   - Desenvolver utilizando TDD;
   - Criar API de relatório;
   - Sumário da quantidade de entrada e saída;
   - Sumário da quantidade de entrada e saída de veículos por hora;
   - Criar uma solução de autenticação.

## Submissão
Crie um fork do teste para acompanharmos o seu desenvolvimento através dos seus commits.

## Obrigado!
Agradecemos sua participação. Boa sorte! 😄

## Requisitos do Projeto

### Tecnologies
- JPA, SpringBoot and H2 for Back-end
- HTML5, CSS, Photoshop, Bootstrap and JavaScript for Front-end

### How to run
- Open the project in Eclipse IDE
- Run ParkApplication.java
- The projects runs on `http://localhost:8080/estacionamentos`


### Services
- List establishments: `http://localhost:8080/estacionamentos`
- Create establishments: `http://localhost:8080/estacionamentos`
- _Header: Contet-Type application/json_
- Update establishments: `http://localhost:8080/estacionamentos/{establishment id}`
- _Header: Contet-Type application/json_
- Delete establishments: `http://localhost:8080/estacionamentos/{establishment id}`

- List vacancies: `http://localhost:8080/estacionamentos/{vacancy id}`

- List vehicles: `http://localhost:8080/estacionamentos/{establishment id}/vagas/{vehicle id}`
- Create vehicles: `http://localhost:8080/estacionamentos/{establishment id}/vagas/{vehicles id}`
- _Header: Contet-Type application/json_
- Update vehicles: `http://localhost:8080/estacionamento/{establishment id}/vagas/{vehicle id}`
- _Header: Contet-Type application/json_
- Delete vehicles: `http://localhost:8080/estacionamentos/{establishment id}/vagas/{vehicle id}`


### Team
- Henrico Lazuroz Moura de Almeida
- Thaue Alfredo Ferreira Lima
- Thiago Henrique Santos
- Vitor Coelho da Silva