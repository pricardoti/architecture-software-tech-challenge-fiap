package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoPorIdOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ConsultarProdutoPorCodigoInboundUseCaseTest {

    @Mock
    private ConsultarProdutoPorIdOutboundPort consultarProdutoPorIdOutboundPort;

    @InjectMocks
    private ConsultarProdutoPorCodigoInboundUseCase consultarProdutoPorCodigoInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarProduto() {
        // Arrange
        UUID codigoProduto = UUID.randomUUID();
        Produto expectedProduto = new Produto();
        when(consultarProdutoPorIdOutboundPort.consultar(codigoProduto)).thenReturn(expectedProduto);

        // Act
        Produto actualProduto = consultarProdutoPorCodigoInboundUseCase.consultar(codigoProduto);

        // Assert
        assertEquals(expectedProduto, actualProduto);
        verify(consultarProdutoPorIdOutboundPort, times(1)).consultar(codigoProduto);
    }

    @Test
    void testConsultarProdutoNotFound() {
        // Arrange
        UUID codigoProduto = UUID.randomUUID();
        when(consultarProdutoPorIdOutboundPort.consultar(codigoProduto)).thenReturn(null);

        // Act
        Produto actualProduto = consultarProdutoPorCodigoInboundUseCase.consultar(codigoProduto);

        // Assert
        assertEquals(null, actualProduto);
        verify(consultarProdutoPorIdOutboundPort, times(1)).consultar(codigoProduto);
    }
}