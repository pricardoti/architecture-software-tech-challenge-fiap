package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.domain.cliente.Cliente;
import br.com.delivery.delivery.application.ports.outbound.cliente.ConsultarClienteOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class ConsultarClienteInboundUseCaseTest {

    @Mock
    private ConsultarClienteOutboundPort consultarClienteOutboundPort;

    @InjectMocks
    private ConsultarClienteInboundUseCase consultarClienteInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarPorCpf() {
        // Arrange
        Cliente clienteEsperado = new Cliente();
        when(consultarClienteOutboundPort.consultarPorCpf(anyString())).thenReturn(clienteEsperado);

        // Act
        Cliente resultado = consultarClienteInboundUseCase.consultarPorCpf("12345678900");

        // Assert
        assertEquals(clienteEsperado, resultado);
    }

    @Test
    void testConsultarClientes() {
        // Arrange
        Cliente cliente1 = new Cliente();
        Cliente cliente2 = new Cliente();
        Collection<Cliente> clientesEsperados = Arrays.asList(cliente1, cliente2);
        when(consultarClienteOutboundPort.consultarClientes()).thenReturn(clientesEsperados);

        // Act
        Collection<Cliente> resultado = consultarClienteInboundUseCase.consultarClientes();

        // Assert
        assertEquals(clientesEsperados, resultado);
    }
}