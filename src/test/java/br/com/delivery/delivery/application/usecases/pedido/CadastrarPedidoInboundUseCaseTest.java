//package br.com.delivery.delivery.application.usecases.pedido;
//
//import br.com.delivery.delivery.application.domain.pedido.Pedido;
//import br.com.delivery.delivery.application.domain.pedido.PedidoProduto;
//import br.com.delivery.delivery.application.domain.produto.Produto;
//import br.com.delivery.delivery.application.ports.inbound.produto.ConsultarProdutoPorIdInboundPort;
//import br.com.delivery.delivery.application.ports.outbound.pedido.CadastrarPedidoOutboundPort;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.math.RoundingMode;
//import java.util.List;
//import java.util.UUID;
//
//import static br.com.delivery.delivery.application.domain.enums.CategoriaProduto.ACOMPANHAMENTO;
//import static br.com.delivery.delivery.application.domain.enums.StatusPedido.AGUARDANDO_PAGAMENTO;
//import static java.math.BigDecimal.valueOf;
//import static java.time.LocalDateTime.now;
//import static org.apache.commons.lang3.StringUtils.EMPTY;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class CadastrarPedidoInboundUseCaseTest {
//
//    @Mock
//    private ConsultarProdutoPorIdInboundPort consultarProdutoPorCodigoInboundUseCase;
//
//    @Mock
//    private CadastrarPedidoOutboundPort cadastrarPedidoOutboundPort;
//
//    @InjectMocks
//    private CadastrarPedidoInboundUseCase cadastrarPedidoInboundUseCase;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void testCadastrarPedidoComSucesso() {
//        // Arrange
//        Produto produto = new Produto(
//                "Batata Frita",
//                "Batata frita com ou sem sal",
//                valueOf(10.00),
//                ACOMPANHAMENTO,
//                EMPTY);
//
//        when(consultarProdutoPorCodigoInboundUseCase.consultar(UUID.randomUUID())).thenReturn(produto);
//        when(cadastrarPedidoOutboundPort.salvar(any(Pedido.class))).thenReturn(getPedido());
//
//        // Act
//        when(cadastrarPedidoInboundUseCase.cadastrar(getPedido())).thenReturn(getPedido());
//
//        // Assert
////        assertNotNull(resultado);
////        assertEquals(valueOf(20.00), resultado.valorTotal());
//        verify(cadastrarPedidoOutboundPort, times(1)).salvar(getPedido());
//    }
//
// /*   @Test
//    void testCadastrarPedidoComQuantidadeInvalida() {
//        // Arrange
//        PedidoProduto pedidoProduto = new PedidoProduto(UUID.randomUUID(), 0);
////        Pedido pedido = new Pedido(List.of(pedidoProduto));
//
//        // Act & Assert
//        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
//            cadastrarPedidoInboundUseCase.cadastrar(getPedido());
//        });
//
//        assertEquals("o produto precisa ter pelo menos uma unidade adicionada ao pedido", exception.getMessage());
//        verify(cadastrarPedidoOutboundPort, never()).salvar(any(Pedido.class));
//    }*/
//
//    /*@Test
//    void testCalcularValorTotalPedido() {
//        // Arrange
//        PedidoProduto pedidoProduto1 = new PedidoProduto(UUID.randomUUID(), 2);
//        PedidoProduto pedidoProduto2 = new PedidoProduto(UUID.randomUUID(), 3);
////        Pedido pedido = new Pedido(List.of(pedidoProduto1, pedidoProduto2));
////        Produto produto1 = new Produto("produto1", "Produto 1", valueOf(10.00));
////        Produto produto2 = new Produto("produto2", "Produto 2", valueOf(20.00));
//
////        when(consultarProdutoPorCodigoInboundUseCase.consultar(UUID.randomUUID())).thenReturn(produto1);
////        when(consultarProdutoPorCodigoInboundUseCase.consultar(UUID.randomUUID())).thenReturn(produto2);
//
//        // Act
////        BigDecimal valorTotal = cadastrarPedidoInboundUseCase.cadastrar(pedido).valorTotal();
//
//        // Assert
//        assertEquals(valueOf(80.00), valorTotal);
//    }*/
//
//    private Produto getProduto() {
//        return new Produto(
//                "Batata Frita",
//                "Batata frita com ou sem sal",
//                valueOf(10.00),
//                ACOMPANHAMENTO,
//                EMPTY);
//    }
//
//    private Pedido getPedido() {
//        return Pedido
//                .builder()
//                .codigoPedido(UUID.randomUUID())
//                .cliente(UUID.randomUUID())
//                .valorTotal(
//                        getProduto()
//                                .preco()
//                                .multiply(
//                                        valueOf(
//                                                getPedidoProduto().quantidade()
//                                        ).setScale(2, RoundingMode.HALF_EVEN)))
//                .produtos(getListPedidoProduto())
//                .status(AGUARDANDO_PAGAMENTO)
//                .dataHoraSolicitacao(now())
//                .build();
//    }
//
//    private PedidoProduto getPedidoProduto() {
//        return new PedidoProduto(
//                UUID.randomUUID(),
//                2
//        );
//    }
//
//    private List<PedidoProduto> getListPedidoProduto() {
//        return List.of(getPedidoProduto());
//    }
//}