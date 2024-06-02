package br.com.delivery.delivery.application.usecases.produto;

import br.com.delivery.delivery.application.domain.produto.Produto;
import br.com.delivery.delivery.application.ports.outbound.produto.EditarProdutoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class EditarProdutoInboundUseCaseTest {

    @Mock
    private EditarProdutoOutboundPort editarProdutoOutboundPort;

    @InjectMocks
    private EditarProdutoInboundUseCase editarProdutoInboundUseCase;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testEditar() {
        // Arrange
        Produto produto = new Produto();
        produto.codigo(UUID.randomUUID());
        produto.nome("Produto Teste");

        Produto produtoEditado = new Produto();
        produtoEditado.codigo(UUID.randomUUID());
        produtoEditado.nome("Produto Editado");

        when(editarProdutoOutboundPort.editar(any(Produto.class))).thenReturn(produtoEditado);

        // Act
        Produto result = editarProdutoInboundUseCase.editar(produto);

        // Assert
        assertEquals(produtoEditado, result);
    }
}