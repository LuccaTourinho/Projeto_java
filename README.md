# Projeto_java
Esse projeto serve para realizar cadastros.
Nele você também fara entradas e saídas no acesso.
Você não poderá fazer uma segunda entrada se você já fez outra entrada e não a finalizou com uma saída.
Não poderá fazer insert's na saída, apenas updates aonde o acesso já tenha uma entrada.


Para fazer os testes use o insonmia.
E crie no postgre um database chamado EstagioJava

-- Para lidar com o cadastro --

Inserir cadastro
POST http://localhost:8080/Cadastro

{
  "nome": "LUCCA TOURINHO",
  "data_nascimento": "1999-11-04",
  "CPF": "12345678998",
  "telefone": "71 987215195",
  "email": "luccatourinho@gmail.com",
  "endereco": {
    "UF": "BA",
    "municipio": "SALVADOR",
    "CEP": "12345-676",
    "complemento": "Apartment 301"
  }
}

Pegar uma lista de cadastros no banco
GET http://localhost:8080/Cadastro
GET http://localhost:8080/Cadastro?size=1&page=0
GET http://localhost:8080/Cadastro?sort=nome

Atualizar Cadastro
PUT http://localhost:8080/Cadastro
{
  "ID_cadastro": 3,
  "telefone": "LUCCA TOURINHO",
  "endereco": {
    "UF": "RJ",
    "municipio": "RIO DE JANEIRO",
    "CEP": "19345-678",
    "complemento": "Apartment 123"
  }
}

Deletar Cadastro
DELETE http://localhost:8080/Cadastro/1


-- Para lidar com Acesso --

Entrada
POST http://localhost:8080/Acesso
{
  "ID_cadastro": 3,
  "entrada": "2023-08-27T10:00:00"
}


Saida
PUT http://localhost:8080/Acesso
{
  "ID_acesso": 2,
  "saida": "2023-08-27T11:30:00"
}


Lista com as permanencia
GET http://localhost:8080/Acesso

Cancelar
DELETE http://localhost:8080/Acesso/1






