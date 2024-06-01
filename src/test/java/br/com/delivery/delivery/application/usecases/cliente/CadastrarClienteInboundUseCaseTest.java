package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.outbound.cliente.CadastrarClienteOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CadastrarClienteInboundUseCaseTest {

    @Mock
    private CadastrarClienteOutboundPort cadastrarClienteOutboundPort;

    @InjectMocks
    private CadastrarClienteInboundUseCase cadastrarClienteInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCadastrar() {
        // Arrange
        Cliente cliente = new Cliente();
        Cliente clienteEsperado = new Cliente();
        when(cadastrarClienteOutboundPort.cadastrar(any(Cliente.class))).thenReturn(clienteEsperado);

        // Act
        Cliente resultado = cadastrarClienteInboundUseCase.cadastrar(cliente);

        // Assert
        assertEquals(clienteEsperado, resultado);
    }
}