package br.com.fiap.global.service;

import br.com.fiap.global.model.ContatoEmergencia;
import br.com.fiap.global.repository.ContatoEmergenciaRepository;
import org.springframework.stereotype.Service;

@Service
public class ContatoEmergenciaService extends BaseService<ContatoEmergencia, Long>{
    public ContatoEmergenciaService(ContatoEmergenciaRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, ContatoEmergencia entity) {
        entity.setId(aLong);
    }
}
