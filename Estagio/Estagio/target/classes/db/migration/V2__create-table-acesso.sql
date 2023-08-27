CREATE TABLE Acesso(
    ID_acesso BIGSERIAL PRIMARY KEY,
    ID_cadastro BIGINT NOT NULL REFERENCES Cadastro(ID_cadastro) ON DELETE CASCADE,
    entrada TIMESTAMP NOT NULL,
	saida TIMESTAMP DEFAULT NULL,
	permanencia TIME DEFAULT NULL,
	CHECK (saida IS NULL OR entrada <= saida)
);