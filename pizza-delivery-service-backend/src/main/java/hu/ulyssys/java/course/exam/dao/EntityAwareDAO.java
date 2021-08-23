package hu.ulyssys.java.course.exam.dao;

import hu.ulyssys.java.course.exam.entity.AbstractPizza;

import java.util.List;

public interface EntityAwareDAO<T extends AbstractPizza> extends CoreDAO<T>
{
        List<T> findByEntityId(Long id);
}
