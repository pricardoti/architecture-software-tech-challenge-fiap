//package br.com.delivery.delivery.adapters.handler;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.hibernate.id.IdentifierGenerationException;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//public class ExceptionHandlerControllerTest {
//
//    private ExceptionHandlerController exceptionHandlerController;
//
//    @BeforeEach
//    public void setUp() {
//        exceptionHandlerController = new ExceptionHandlerController();
//    }
//
//    @Test
//    public void testHandleMethodArgumentNotValidException() {
//        BindingResult bindingResult = mock(BindingResult.class);
//        FieldError fieldError = new FieldError("objectName", "field", "defaultMessage");
//        when(bindingResult.getFieldErrors()).thenReturn(List.of(fieldError));
//        MethodArgumentNotValidException exception = new MethodArgumentNotValidException(null, bindingResult);
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleIllegalArgumentException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Parametros ou body da requisao invalido", response.getBody().getMessage());
//        assertEquals("Field 'field' defaultMessage", response.getBody().getDetails());
//    }
//
//    @Test
//    public void testHandleEntityNotFoundException() {
//        EntityNotFoundException exception = new EntityNotFoundException();
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleOrderAlreadyWithStatus(exception);
//
//        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//    }
//
//    @Test
//    public void testHandleIllegalArgumentException() {
//        IllegalArgumentException exception = new IllegalArgumentException("Invalid argument");
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleIllegalArgumentException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Parametros ou body da requisao invalido", response.getBody().getMessage());
//        assertEquals("Invalid argument", response.getBody().getDetails());
//    }
//
//    @Test
//    public void testHandleDuplicateKeyException() {
//        DuplicateKeyException exception = new DuplicateKeyException("Duplicate key");
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleDuplicateKeyException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Verifique as informacoes da request", response.getBody().getMessage());
//        assertEquals("Duplicate key", response.getBody().getDetails());
//    }
//
//    @Test
//    public void testHandleHttpMessageNotReadableException() {
//        HttpMessageNotReadableException exception = new HttpMessageNotReadableException("Message not readable");
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleDuplicateKeyException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Verifique as informacoes da request", response.getBody().getMessage());
//        assertEquals("Message not readable", response.getBody().getDetails());
//    }
//
//    @Test
//    public void testHandleIdentifierGenerationException() {
//        IdentifierGenerationException exception = new IdentifierGenerationException("Identifier generation error");
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleDuplicateKeyException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Verifique as informacoes da request", response.getBody().getMessage());
//        assertEquals("Identifier generation error", response.getBody().getDetails());
//    }
//
//    @Test
//    public void testHandleException() {
//        Exception exception = new Exception("General error");
//
//        ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleException(exception);
//
//        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
//        assertEquals("Nao foi possivel processar a requisicao", response.getBody().getMessage());
//        assertEquals("General error", response.getBody().getDetails());
//    }
//}