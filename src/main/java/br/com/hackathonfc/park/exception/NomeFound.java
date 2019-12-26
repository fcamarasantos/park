package br.com.hackathonfc.park.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NomeFound extends Exception{
    @Override
    public String getMessage() {
        return "Nome já cadastrado no sistema!";
    }
}
