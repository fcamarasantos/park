package br.com.hackathonfc.park.exception;

public class VagaNotFound extends Exception {
    @Override
    public String getMessage() {
        return "Vaga não encontrada no sistema!";
    }
}
