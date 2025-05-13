CREATE TABLE cliente (
    id BIGINT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cnpj VARCHAR(14) NOT NULL UNIQUE,
    atividade_economica VARCHAR(255),
    responsavel VARCHAR(255)
);