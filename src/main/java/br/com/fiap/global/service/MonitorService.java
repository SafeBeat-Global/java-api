package br.com.fiap.global.service;

import br.com.fiap.global.model.Monitor;
import br.com.fiap.global.repository.MonitorRepository;
import org.springframework.stereotype.Service;

@Service
public class MonitorService extends BaseService<Monitor, Long>{
    public MonitorService(MonitorRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, Monitor entity) {
        entity.setId(aLong);
    }
}
