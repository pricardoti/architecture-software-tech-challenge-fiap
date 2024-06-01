package br.com.delivery.delivery.application.usecases.cliente;

import br.com.delivery.delivery.application.ports.outbound.cliente.ExcluirClienteOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.verify;

class ExcluirClienteInboundUseCaseTest {

    @Mock
    private ExcluirClienteOutboundPort excluirClienteOutboundPort;

    @InjectMocks
    private ExcluirClienteInboundUseCase excluirClienteInboundUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testExcluir() {
        // Arrange
        UUID codigoCliente = UUID.randomUUID();

        // Act
        excluirClienteInboundUseCase.excluir(codigoCliente);

        // Assert
        verify(excluirClienteOutboundPort).excluir(codigoCliente);
    }
}