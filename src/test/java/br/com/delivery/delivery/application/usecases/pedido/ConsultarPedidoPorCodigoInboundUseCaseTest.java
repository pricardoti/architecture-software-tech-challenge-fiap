package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.domain.pedido.PedidoProduto;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoPorCodigoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import static br.com.delivery.delivery.application.domain.enums.StatusPedido.PRONTO_ENTREGA;
import static java.time.LocalDateTime.now;
import static java.util.UUID.randomUUID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConsultarPedidoPorCodigoInboundUseCaseTest {

    @Mock
    private ConsultarPedidoPorCodigoOutboundPort consultarPedidoPorCodigoOutboundPort;

    @InjectMocks
    private ConsultarPedidoPorCodigoInboundUseCase consultarPedidoPorCodigoInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarPedidoPorCodigo() {
        UUID codigoPedido = randomUUID();
        Pedido pedido = buildPedido();
        when(consultarPedidoPorCodigoOutboundPort.consultar(codigoPedido)).thenReturn(pedido);

        Pedido resultado = consultarPedidoPorCodigoInboundUseCase.consultar(codigoPedido);

        assertEquals(pedido, resultado);
    }

    @Test
    void testConsultarPedidoPorCodigoThrowsIllegalArgumentException() {
        when(consultarPedidoPorCodigoOutboundPort
                .consultar(UUID.randomUUID()))
                .thenReturn(null);
        try {
            consultarPedidoPorCodigoInboundUseCase.consultar(null);
        } catch (Exception e) {
            assertEquals(e.getMessage(), "pedido nao encontrado");
        }
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
