package br.com.hackathonfc.park.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VeiculoNotFound extends Exception{
    @Override
    public String getMessage() {
        return "Veículo não encontrado no sistema!";
    }
}
