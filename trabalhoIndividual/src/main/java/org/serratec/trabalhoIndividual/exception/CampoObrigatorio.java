package org.serratec.trabalhoIndividual.exception;

public class CampoObrigatorio extends RuntimeException {
    public CampoObrigatorio(String message) {
        super(message);
    }
}
