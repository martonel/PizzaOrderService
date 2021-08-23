package hu.ulyssys.java.course.exam.impl;


import hu.ulyssys.java.course.exam.dao.EntityAwareDAO;
import hu.ulyssys.java.course.exam.entity.AbstractPizza;
import hu.ulyssys.java.course.exam.service.EntityAwareService;

import java.util.List;


public abstract class AbstractEntityServiceImpl<T extends AbstractPizza> extends AbstractServiceImpl<T> implements EntityAwareService<T> {
    @Override
    public List<T> findByEntityId(Long id) {
        return ((EntityAwareDAO<T>) dao).findByEntityId(id);
    }
}
