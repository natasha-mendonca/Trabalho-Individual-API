package org.serratec.trabalhoIndividual.exception;

import org.serratec.trabalhoIndividual.model.MensagemDeErro;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ClienteNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro> handleClienteNaoEcontrado(ClienteNaoEncontrado ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDeErro(ex.getMessage()));
    }

    @ExceptionHandler(VeiculoNaoEncontrado.class)
    public ResponseEntity<MensagemDeErro> handleVeiculoNaoEcontrado(VeiculoNaoEncontrado ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MensagemDeErro(ex.getMessage()));
    }

    @ExceptionHandler(CpfJaCadastrado.class)
    public ResponseEntity<MensagemDeErro> handleCpfJaCadastrado(CpfJaCadastrado ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MensagemDeErro(ex.getMessage()));
    }

    @ExceptionHandler(PlacaJaCadastrada.class)
    public ResponseEntity<MensagemDeErro> handlePlacaJaCadastrada(PlacaJaCadastrada ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new MensagemDeErro(ex.getMessage()));
    }

    @ExceptionHandler(CampoObrigatorio.class)
    public ResponseEntity<MensagemDeErro> handleCampoObrigatorio(CampoObrigatorio ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDeErro(ex.getMessage()));
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        String mensagem = ex
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(i -> i.getField() + " " + i.getDefaultMessage())
                .collect(Collectors.joining(","));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MensagemDeErro(mensagem));
    }
}
