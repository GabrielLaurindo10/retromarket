package br.edu.ifce.retromarket.controllers.exeptions;

public class ResourceNotFoundExceptions extends RuntimeException {
    public ResourceNotFoundExceptions(String message) {
        super(message);
    }

}
