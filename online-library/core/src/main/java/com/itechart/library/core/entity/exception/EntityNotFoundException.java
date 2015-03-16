package com.itechart.library.core.entity.exception;

public class EntityNotFoundException extends ApplicationException {
    public EntityNotFoundException(Object entityKey) {
        super(String.format("Entity not found using '%s'", entityKey));
    }
}
