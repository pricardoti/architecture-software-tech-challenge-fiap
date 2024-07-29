package br.com.fiap.delivery.application.gateways;

import br.com.fiap.delivery.domain.pedido.Pedido;

public interface PagamentoGateway {

    String gerarQrDinamico(Pedido pedido);
}
