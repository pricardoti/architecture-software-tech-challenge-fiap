package br.com.delivery.delivery.adapters.config;

import br.com.delivery.delivery.application.ports.inbound.avaliacao.CadastrarAvaliacaoPort;
import br.com.delivery.delivery.application.ports.inbound.avaliacao.ConsultarAvaliacaoPort;
import br.com.delivery.delivery.application.ports.inbound.avaliacao.EditarAvaliacaoPort;
import br.com.delivery.delivery.application.ports.inbound.avaliacao.ExcluirAvaliacaoPort;
import br.com.delivery.delivery.application.ports.outbound.avaliacao.SalvarAvaliacaoPort;
import br.com.delivery.delivery.application.usecases.avaliacao.CadastrarAvaliacaoUseCase;
import br.com.delivery.delivery.application.usecases.avaliacao.ConsultarAvaliacaoUseCase;
import br.com.delivery.delivery.application.usecases.avaliacao.EditarAvaliacaoUseCase;
import br.com.delivery.delivery.application.usecases.avaliacao.ExcluirAvaliacaoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AvaliacaoBeanConfig {

    @Bean
    public CadastrarAvaliacaoPort cadastrarAvaliacaoPort(SalvarAvaliacaoPort salvarAvaliacaoPort) {
        return new CadastrarAvaliacaoUseCase(salvarAvaliacaoPort);
    }

    @Bean
    public EditarAvaliacaoPort editarAvaliacaoPort() {
        return new EditarAvaliacaoUseCase();
    }

    @Bean
    public ConsultarAvaliacaoPort consultarAvaliacaoPort() {
        return new ConsultarAvaliacaoUseCase();
    }

    @Bean
    public ExcluirAvaliacaoPort excluirAvaliacaoPort() {
        return new ExcluirAvaliacaoUseCase();
    }
}
