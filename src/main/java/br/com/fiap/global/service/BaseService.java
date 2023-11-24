package br.com.fiap.global.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<T, ID> {
    private final JpaRepository<T, ID> repository;

    public BaseService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    public List<T> getAll() {
        return repository.findAll();
    }

    public T getById(ID id) {
        Optional<T> optionalEntity = repository.findById(id);
        return optionalEntity.orElse(null);
    }

    public T create(T entity) {
        return repository.save(entity);
    }

    public T update(ID id, T entity) {
        setId(id, entity);
        if (repository.existsById(id)) {
            return repository.save(entity);
        }
        return null;
    }

    protected abstract void setId(ID id, T entity);

    public void delete(ID id) {
        repository.deleteById(id);
    }
}