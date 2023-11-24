package br.com.fiap.global.service;

import br.com.fiap.global.model.Usuario;
import br.com.fiap.global.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends BaseService<Usuario, Long>{
    public UsuarioService(UsuarioRepository repository) {
        super(repository);
    }

    @Override
    protected void setId(Long aLong, Usuario entity) {
        entity.setId(aLong);
    }
}
