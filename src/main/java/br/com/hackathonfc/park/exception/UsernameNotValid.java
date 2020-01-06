package br.com.hackathonfc.park.exception;

public class UsernameNotValid extends Exception {

    @Override
    public String getMessage() {
        return "Nome de usuário inválido!";
    }
}
