package br.com.delivery.delivery.application.ports.inbound.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;

import java.util.UUID;

public interface ConsultarAvaliacaoPort {

    Avaliacao consultar(UUID idAvaliacao);
}
