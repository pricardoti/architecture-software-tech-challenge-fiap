package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.ports.outbound.produto.ExcluirProdutoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.mockito.Mockito.verify;

class ExcluirProdutoInboundUseCaseTest {

    @Mock
    private ExcluirProdutoOutboundPort produtoOutboundPort;

    @InjectMocks
    private ExcluirProdutoInboundUseCase excluirProdutoInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void excluir_deveChamarExcluirDoOutboundPort() {
        // Arrange
        UUID codigoProduto = UUID.randomUUID();

        // Act
        excluirProdutoInboundUseCase.excluir(codigoProduto);

        // Assert
        verify(produtoOutboundPort).excluir(codigoProduto);
    }
}
