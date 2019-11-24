INSERT INTO ESTACIONAMENTO(nome, cnpj, telefone, vagasMotos, vagasCarros) VALUES("Estacionamento 1", 1234556, 123456, 10, 20)
INSERT INTO ESTACIONAMENTO(nome, cnpj, telefone, vagasMotos, vagasCarros) VALUES("Estacionamento 1", 1234556, 123456, 10, 20)
INSERT INTO ESTACIONAMENTO(nome, cnpj, telefone, vagasMotos, vagasCarros) VALUES("Estacionamento 1", 1234556, 123456, 10, 20)

INSERT INTO VEICULO(marca, cor, placa) VALUES("Marca 1", "Preto", "FFFF-4444")
INSERT INTO VEICULO(marca, cor, placa) VALUES("Marca 1", "Preto", "FFFF-4444")
INSERT INTO VEICULO(marca, cor, placa) VALUES("Marca 1", "Preto", "FFFF-4444")

INSERT INTO VAGA (estacionamento.id, carro.id, dataInicio, dataSaida, livre) VALUES(1, 1, "2019-11-24 12:00:00", "2019-11-24 13:00:00", false)
INSERT INTO VAGA (estacionamento.id, carro.id, dataInicio, dataSaida, livre) VALUES(1, null, "", "", true)
INSERT INTO VAGA (estacionamento.id, carro.id, dataInicio, dataSaida, livre) VALUES(1, 1, "2019-11-24 12:00:00", "2019-11-24 13:00:00", false)

