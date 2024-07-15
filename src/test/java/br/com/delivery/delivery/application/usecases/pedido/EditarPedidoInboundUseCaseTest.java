package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.domain.pedido.PedidoProduto;
import br.com.delivery.delivery.application.ports.outbound.pedido.EditarPedidoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;

import static br.com.delivery.delivery.application.domain.enums.StatusPedido.AGUARDANDO_PAGAMENTO;
import static br.com.delivery.delivery.application.domain.enums.StatusPedido.PRONTO_ENTREGA;
import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;
import static org.mockito.Mockito.when;

public class EditarPedidoInboundUseCaseTest {

    @Mock
    private EditarPedidoOutboundPort editarPedidoOutboundPort;

    @InjectMocks
    private EditarPedidoInboundUseCase editarPedidoInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testEditarPedido() {
        Pedido pedido = buildPedido();
        when(editarPedidoOutboundPort.editar(pedido)).thenReturn(void);
    }

    private Pedido buildPedido() {
        return Pedido
                .builder()
                .codigoPedido(randomUUID())
                .cliente(randomUUID())
                .valorTotal(BigDecimal.valueOf(25.00))
                .produtos(List.of(buildProdutos()))
                .status(PRONTO_ENTREGA)
                .dataHoraSolicitacao(now())
                .build();
    }

    private PedidoProduto buildProdutos() {
        return new PedidoProduto(randomUUID(), 2);
    }
}
