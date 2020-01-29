package br.com.hackathonfc.park.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EstacionamentoNotFound extends Exception {
    @Override
    public String getMessage() {
        return "Estacionamento não encontrado no sistema!";
    }
}
