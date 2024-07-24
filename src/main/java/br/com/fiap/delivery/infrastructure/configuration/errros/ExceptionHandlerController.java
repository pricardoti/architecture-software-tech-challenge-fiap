package br.com.fiap.delivery.infrastructure.configuration.errros;

import br.com.fiap.delivery.application.exception.CadastroUsuarioException;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.dao.DataIntegrityViolationException;
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
        var details = "field '" + field.getField() + "' " + field.getDefaultMessage();
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO("parametros ou body da requisao invalido", details));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleOrderAlreadyWithStatus(EntityNotFoundException exception) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorDTO> handleOrderAlreadyWithStatus(DataIntegrityViolationException exception) {
        return handlerExceptionPadrao("nao foi possivel processar a requisicao", "erro ao realizar a consulta e/ou operação na base de dados, verifique as informações preenchidas.");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDTO> handleIllegalArgumentException(IllegalArgumentException exception) {
        return handlerExceptionPadrao("parametros ou body da requisao invalido", exception.getMessage());
    }

    @ExceptionHandler({DuplicateKeyException.class, HttpMessageNotReadableException.class, IdentifierGenerationException.class})
    public ResponseEntity<ErrorDTO> handleDuplicateKeyException(Exception exception) {
        return handlerExceptionPadrao("verifique as informacoes da request", exception.getMessage());
    }

    @ExceptionHandler(CadastroUsuarioException.class)
    public ResponseEntity<ErrorDTO> handleException(CadastroUsuarioException exception) {
        return handlerExceptionPadrao("erro ao tentar cadastror ou consultar o usuário informado.", exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleException(Exception exception) {
        return handlerExceptionPadrao("nao foi possivel processar a requisicao", exception.getMessage());
    }

    private static ResponseEntity<ErrorDTO> handlerExceptionPadrao(String messagem, String detalhes) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(messagem, detalhes));
    }
}