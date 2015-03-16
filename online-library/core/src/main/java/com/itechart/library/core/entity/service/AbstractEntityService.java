package com.itechart.library.core.entity.service;

import com.itechart.library.core.entity.Entity;
import com.itechart.library.core.entity.exception.EntityNotFoundException;
import com.itechart.library.core.entity.repository.EntityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractEntityService<T extends Entity> {
    protected T load(long id) {
        T entity = getRepository().findOne(id);
        if (entity == null) {
            throw new EntityNotFoundException(id);
        }
        return entity;
    }

    @Transactional(readOnly = true)
    public T find(long id) {
        return getRepository().findOne(id);
    }

    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    protected abstract EntityRepository<T> getRepository();
}
