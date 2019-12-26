package br.com.hackathonfc.park.exception;

public class CnpjFound extends Exception {
    @Override
    public String getMessage() {
        return "Cnpj já cadastrado no sistema!";
    }
}
