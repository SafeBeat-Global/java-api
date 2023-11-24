package br.com.fiap.global.service;

import br.com.fiap.global.model.Moderador;
import br.com.fiap.global.repository.ModeradorRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeradorService extends BaseService<Moderador, Long>{
    public ModeradorService(ModeradorRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, Moderador entity) {
        entity.setId(aLong);
    }
}
