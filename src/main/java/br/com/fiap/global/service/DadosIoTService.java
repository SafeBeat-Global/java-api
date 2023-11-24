package br.com.fiap.global.service;

import br.com.fiap.global.model.DadosIoT;
import br.com.fiap.global.repository.DadosIoTRepository;
import org.springframework.stereotype.Service;

@Service
public class DadosIoTService extends BaseService<DadosIoT, Long>{
    public DadosIoTService(DadosIoTRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, DadosIoT entity) {
        entity.setId(aLong);
    }
}
