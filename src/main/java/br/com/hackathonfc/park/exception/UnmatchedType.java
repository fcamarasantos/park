package br.com.hackathonfc.park.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UnmatchedType extends Exception{
    @Override
    public String getMessage() {
        return "Este veículo não pode estacionar nesta vaga!";
    }
}
