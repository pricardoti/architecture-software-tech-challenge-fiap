package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.enums.CategoriaProduto;
import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.ConsultarProdutoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ConsultarProdutoInboundUseCaseTest {

    @Mock
    private ConsultarProdutoOutboundPort consultarProdutoOutboundPort;

    @InjectMocks
    private ConsultarProdutoInboundUseCase consultarProdutoInboundUseCase;

    private CategoriaProduto categoria;

    @BeforeEach
    public void setUp() {
        categoria = CategoriaProduto.ACOMPANHAMENTO; // Example category
    }

    @Test
    public void testConsultarWithResults() {
        // Arrange
        Produto produto1 = new Produto(); // Create a sample product
        Produto produto2 = new Produto(); // Create another sample product
        Collection<Produto> expectedProdutos = Arrays.asList(produto1, produto2);

        when(consultarProdutoOutboundPort.consultar(categoria)).thenReturn(expectedProdutos);

        // Act
        Collection<Produto> actualProdutos = consultarProdutoInboundUseCase.consultar(categoria);

        // Assert
        assertEquals(expectedProdutos, actualProdutos);
        verify(consultarProdutoOutboundPort, times(1)).consultar(categoria);
    }

    @Test
    public void testConsultarWithNoResults() {
        // Arrange
        Collection<Produto> expectedProdutos = Collections.emptyList();

        when(consultarProdutoOutboundPort.consultar(categoria)).thenReturn(expectedProdutos);

        // Act
        Collection<Produto> actualProdutos = consultarProdutoInboundUseCase.consultar(categoria);

        // Assert
        assertEquals(expectedProdutos, actualProdutos);
        verify(consultarProdutoOutboundPort, times(1)).consultar(categoria);
    }
}