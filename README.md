# Wine Cep Api

O objetivo desse projeto é criar uma Api para cadastrar faixas de CEP para lojas físicas e também retornar uma loja física a partir de um Cep informado

# Dependências

* Maven
* JDK 11

# Arquitetura

O projeto foi feito utilizando a versão 11 do Java, com o framework Spring. 


### Testando a API

Alguns exemplos de pesquisas: 

-- Todas as faixas de CEP
Método: GET
http://localhost:8080/cep/

-- Atualizar
Método: PUT
http://localhost:8080/cep/{id}
{
    "faixaInicio": "10000001",
    "faixaFim":"20000000"
}

-- Inserir
Método: Post
http://localhost:8080/cep/
{
    "codigoLoja":"LOJA_JARDINS",
    "faixaInicio": "40000001",
    "faixaFim":"50000000"
}

-- Todas as faixas de CEP
Método: DELETE
http://localhost:8080/cep/{id}

-- Encontrar a loja mais próxima ao cliente
http://localhost:8080/cep/filter/{cep_cliente}
Response: "A loja existente para o seu CEP é: LOJA_PINHEIROS" ou 
"Por enquanto não existe uma loja para o CEP informado"