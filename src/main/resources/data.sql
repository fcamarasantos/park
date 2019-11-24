INSERT INTO ESTACIONAMENTO(nome, cnpj, endereco, telefone, vagas_motos, vagas_carros, preco_hora) VALUES('Estacionamento 1', '1234556', 'Rua Doutor Fulano, 505 - Aparecida, Santos/SP', '123456', '10', '20', '8.50')
INSERT INTO ESTACIONAMENTO(nome, cnpj, endereco ,telefone, vagas_motos, vagas_carros, preco_hora) VALUES('Estacionamento 1', '1234556', 'Rua Doutor Fulano 2, 403 - Embaré, Santos/SP', '123456', '10', '20', '7.80')
INSERT INTO ESTACIONAMENTO(nome, cnpj, endereco ,telefone, vagas_motos, vagas_carros, preco_hora) VALUES('Estacionamento 1', '1234556', 'Rua Doutor Fulano 3, 306 - Mocca, São Paulo/SP', '123456', '10', '20', '9.50')

INSERT INTO VEICULO(marca, cor, placa) VALUES('Marca 1', 'Preto', 'FFFF-4444')
INSERT INTO VEICULO(marca, cor, placa) VALUES('Marca 1', 'Preto', 'FFFF-4444')
INSERT INTO VEICULO(marca, cor, placa) VALUES('Marca 1', 'Preto', 'FFFF-4444')

INSERT INTO VAGA(estacionamento_id, veiculo_id, data_inicio, data_saida, livre) VALUES('1', '1', '2019-11-24 12:00:00', '2019-11-24 13:00:00', false)
INSERT INTO VAGA(estacionamento_id, veiculo_id, data_inicio, data_saida, livre) VALUES('1', null, null, null, true)
INSERT INTO VAGA(estacionamento_id, veiculo_id, data_inicio, data_saida, livre) VALUES('1', '1', '2019-11-24 12:00:00', '2019-11-24 13:00:00', false)
