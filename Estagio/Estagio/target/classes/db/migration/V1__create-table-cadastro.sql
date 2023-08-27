CREATE TABLE Cadastro (
    ID_cadastro BIGSERIAL PRIMARY KEY,
    nome VARCHAR(60) NOT NULL,
    data_nascimento DATE NOT NULL,
    CPF VARCHAR(11) NOT NULL,
    telefone VARCHAR(13) NOT NULL,
    email VARCHAR(40) NOT NULL,
    UF VARCHAR(2) NOT NULL,
    municipio VARCHAR(40) NOT NULL,
    CEP VARCHAR(9) NOT NULL,
    complemento VARCHAR(255) NOT NULL
);
