INSERT INTO ESTACIONAMENTO(id, nome, cnpj, endereco, telefone, vagas_motos, vagas_carros, preco_hora) VALUES(1, 'Estacionamento 1', '1234556', 'Rua Doutor Fulano, 505 - Aparecida, Santos/SP', '123456', '4', '4', '8.50')
INSERT INTO ESTACIONAMENTO(id, nome, cnpj, endereco ,telefone, vagas_motos, vagas_carros, preco_hora) VALUES(2, 'Estacionamento 2', '1234556', 'Rua Doutor Fulano 2, 403 - Embaré, Santos/SP', '123456', '8', '8', '7.80')
INSERT INTO ESTACIONAMENTO(id, nome, cnpj, endereco ,telefone, vagas_motos, vagas_carros, preco_hora) VALUES(3, 'Estacionamento 3', '1234556', 'Rua Doutor Fulano 3, 306 - Mocca, São Paulo/SP', '123456', '5', '5', '9.50')

INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(1, false, 'CARRO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(1, true, 'CARRO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(1, false, 'MOTO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(2, true, 'CARRO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(2, true, 'MOTO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(2, true, 'CARRO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(3, true, 'CARRO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(3, true, 'MOTO')
INSERT INTO VAGA(estacionamento_id, livre, tipo_vaga) VALUES(3, true, 'MOTO')


INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(1, 'Ford', 'Mustang', 'Preto', 'FORD-4444', 'CARRO', 1)
INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(2, 'BMW', 'S1000RR', 'Vermelho', 'MALB-6666', 'MOTO', 3)

INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(3, 'Chevrolet', 'Cruze', 'Prata', 'VVVV-6969', 'CARRO', 4)
INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(4, 'Honda', 'PCX', 'Branco', 'HOND-6372', 'MOTO', 5)

INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(5, 'Fiat', 'Punto', 'Branco', 'FIAT-6666', 'CARRO', 7)
INSERT INTO VEICULO(id, marca, modelo, cor, placa, tipo_veiculo, vaga_id) VALUES(6, 'Harley Davidson', 'Fat Boy 2014', 'Vermelho', 'HARL-1882', 'MOTO', 8)

