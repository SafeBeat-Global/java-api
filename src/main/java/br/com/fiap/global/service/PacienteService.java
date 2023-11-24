package br.com.fiap.global.service;

import br.com.fiap.global.model.Paciente;
import br.com.fiap.global.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class PacienteService extends BaseService<Paciente, Long>{
    public PacienteService(PacienteRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, Paciente entity) {
        entity.setId(aLong);
    }
}
