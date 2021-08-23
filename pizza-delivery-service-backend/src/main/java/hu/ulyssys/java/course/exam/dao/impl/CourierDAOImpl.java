package hu.ulyssys.java.course.exam.dao.impl;

import hu.ulyssys.java.course.exam.dao.CourierDAO;
import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.entity.Courier;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CourierDAOImpl extends AbstractEntityAwareDAOImpl<Courier> implements CourierDAO {
    @Override
    public Courier findByName(String name) {
        TypedQuery<Courier> query = entityManager.createNamedQuery(Courier.FIND_BY_NAME, Courier.class);
        query.setParameter("firstName", name);
        List<Courier> courierList = query.getResultList();
        if (courierList.isEmpty()) {
            return null;
        }
        return courierList.get(0);
    }

    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }

}
