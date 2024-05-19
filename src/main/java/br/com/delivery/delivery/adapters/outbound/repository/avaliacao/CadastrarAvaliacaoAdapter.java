package br.com.delivery.delivery.adapters.outbound.repository.avaliacao;

import br.com.delivery.delivery.application.domain.avaliacao.Avaliacao;
import br.com.delivery.delivery.application.ports.outbound.avaliacao.SalvarAvaliacaoPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CadastrarAvaliacaoAdapter implements SalvarAvaliacaoPort {

    private final AvaliacaoRepository avaliacaoRepository;

    @Override
    public Avaliacao salvar(Avaliacao avaliacao) {
        avaliacaoRepository.save(AvaliacaoEntity.from(avaliacao));
        return avaliacao;
    }
}
