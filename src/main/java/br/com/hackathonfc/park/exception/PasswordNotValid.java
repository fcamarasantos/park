package br.com.hackathonfc.park.exception;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PasswordNotValid extends Exception{

    @Override
    public String getMessage() {
        return "Senha de usuário inválida!";
    }
}
