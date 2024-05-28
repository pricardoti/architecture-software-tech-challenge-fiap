package br.com.delivery.delivery.adapters.handler;

import jakarta.persistence.EntityNotFoundException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Locale;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(MethodArgumentNotValidException exception) {
        Locale.setDefault(Locale.US);
        var field = exception.getBindingResult().getFieldErrors().getFirst();
        var details = "Field '" + field.getField() + "' " + field.getDefaultMessage();
        return ResponseEntity
                .badRequest()
                .body(
                        new ErrorDTO("Parametros ou body da requisao invalido", details)
                );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleOrderAlreadyWithStatus(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException exception) {
        return handlerExceptionPadrao("Parametros ou body da requisao invalido", exception);
    }

    @ExceptionHandler({DuplicateKeyException.class, HttpMessageNotReadableException.class, IdentifierGenerationException.class})
    public ResponseEntity<ErrorDTO> handleDuplicateKeyException(Exception exception) {
        return handlerExceptionPadrao("Verifique as informacoes da request", exception);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception exception) {
        return handlerExceptionPadrao("Nao foi possivel processar a requisicao", exception);
    }

    private static ResponseEntity<ErrorDTO> handlerExceptionPadrao(String messagem, Exception exception) {
        return ResponseEntity
                .badRequest()
                .body(
                        new ErrorDTO(messagem, exception.getCause().getMessage())
                );
    }
}