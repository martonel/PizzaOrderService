package hu.ulyssys.java.course.exam.dao.impl;


import hu.ulyssys.java.course.exam.dao.EntityAwareDAO;
import hu.ulyssys.java.course.exam.entity.AbstractPizza;

import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractEntityAwareDAOImpl<T extends AbstractPizza> extends CoreDAOImpl<T> implements EntityAwareDAO<T> {

    @Override
    public List<T> findByEntityId(Long id) {
        TypedQuery<T> query = entityManager.createQuery("select n from " + getManagedClass().getSimpleName() + " n where n.creator.id=:id order by n.id", getManagedClass());
        query.setParameter("id", id);
        return query.getResultList();
    }
}
