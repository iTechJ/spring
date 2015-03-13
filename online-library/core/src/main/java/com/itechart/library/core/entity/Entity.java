package com.itechart.library.core.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;

@MappedSuperclass
public class Entity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    @SequenceGenerator(name = "seq", sequenceName = "SQ_LIB")
    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entity)) {
            return false;
        }

        Entity that = (Entity) o;

        if (!getClass().equals(that.getClass())) {
            return false;
        }

        if (this.getId() == 0) {
            throw new IllegalStateException("Couldn't compare: id of THIS entity is zero");
        }

        if (that.getId() == 0) {
            throw new IllegalArgumentException("Couldn't compare: id of THAT entity is zero");
        }

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        if (this.getId() == 0) {
            throw new IllegalStateException("id is zero");
        }
        return (int) (this.getId() ^ (this.getId() >>> 32));
    }
}
