package br.com.delivery.delivery.application.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedido {

    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
    EM_PREPARACAO("EM_PREPARACAO"),
    PRONTO_ENTREGA("PRONTO_ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private final String status;

}
