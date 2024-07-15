package br.com.delivery.delivery.application.usecases.pedido;

import br.com.delivery.delivery.application.domain.pedido.Pedido;
import br.com.delivery.delivery.application.ports.outbound.pedido.ConsultarPedidoOutboundPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class ConsultarPedidoInboundUseCaseTest {

    @Mock
    private ConsultarPedidoOutboundPort consultarPedidoOutboundPort;

    @InjectMocks
    private ConsultarPedidoInboundUseCase consultarPedidoInboundUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConsultarPedido() {
        // Arrange
        Collection<Pedido> pedidos = new ArrayList<Pedido>();
        when(consultarPedidoOutboundPort.consultar()).thenReturn(pedidos);

        // Act
        Collection<Pedido> resultado = consultarPedidoInboundUseCase.consultar();

        // Assert
        assertEquals(pedidos, resultado);
    }

}