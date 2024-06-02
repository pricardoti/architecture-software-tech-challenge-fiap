package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.CadastrarProdutoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CadastrarProdutoInboundUseCaseTest {

    @Mock
    private CadastrarProdutoOutboundPort cadastrarProdutoOutboundPort;

    @InjectMocks
    private CadastrarProdutoInboundUseCase cadastrarProdutoInboundUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCadastrarProduto() {
        // Arrange
        Produto produto = new Produto();
        Produto expectedProduto = new Produto();
        when(cadastrarProdutoOutboundPort.cadastrar(any(Produto.class))).thenReturn(expectedProduto);

        // Act
        Produto result = cadastrarProdutoInboundUseCase.cadastrar(produto);

        // Assert
        assertEquals(expectedProduto, result);
        verify(cadastrarProdutoOutboundPort, times(1)).cadastrar(produto);
    }

    @Test
    public void testCadastrarProduto_NullProduto() {
        // Arrange
        Produto produto = null;
        Produto expectedProduto = null;
        when(cadastrarProdutoOutboundPort.cadastrar(any(Produto.class))).thenReturn(expectedProduto);

        // Act
        Produto result = cadastrarProdutoInboundUseCase.cadastrar(produto);

        // Assert
        assertEquals(expectedProduto, result);
        verify(cadastrarProdutoOutboundPort, times(1)).cadastrar(produto);
    }
}