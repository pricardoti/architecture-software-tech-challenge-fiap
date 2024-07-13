package br.com.delivery.delivery.application.domain.enums;

public enum StatusPedido {

    AGUARDANDO_PAGAMENTO("AGUARDANDO_PAGAMENTO"),
    EM_PREPARACAO("EM_PREPARACAO"),
    PRONTO_ENTREGA("PRONTO_ENTREGA"),
    CANCELADO("CANCELADO"),
    FINALIZADO("FINALIZADO");

    private final String status;

    StatusPedido(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
