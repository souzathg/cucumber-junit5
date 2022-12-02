# Cucumber with JUnit5

## Resumo
Esse repositório tem como finalidade servir como base para os testes de aceitação para os times de Arranjo de Pagamento da CERC.
Nesse repositório, foi criada uma aplicação de Calculadora em _Spring Boot_ para que sejam realizados os testes de aceitação usando _[Cucumber](https://cucumber.io/)_.

## Executando a aplicação
Para que os testes possam ser realizados, a aplicação deve estar em execução.
Para isso, basta executar o método _main_ da classe _Application.java_ e o _Spring Boot_ já disponibilizará a aplicação no endereço [http://localhost:8080](http://localhost:8080). 

### Endpoints
Endpoint de health check para garantir que a aplicação está funcionando.
- GET `/health`


Endpoints de operações.
- POST `/sum`
- POST `/divide`

Para esses endpoints o payload é conforme segue:
```javascript
{
  "num1": 5.0, // double 
  "num2": 5.0 // double
}
```

## Testes
As features de teste estão definidas na pasta _resources_,  e as definições estão definidas na pasta _steps_.
