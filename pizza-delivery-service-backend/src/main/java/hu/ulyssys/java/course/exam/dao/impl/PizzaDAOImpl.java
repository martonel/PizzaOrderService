package hu.ulyssys.java.course.exam.dao.impl;

import hu.ulyssys.java.course.exam.dao.PizzaDAO;
import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.entity.Pizza;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class PizzaDAOImpl extends AbstractEntityAwareDAOImpl<Pizza> implements PizzaDAO {
    @Override
    protected Class<Pizza> getManagedClass() {
        return Pizza.class;
    }

    @Override
    public Pizza findByName(String name) {
        TypedQuery<Pizza> query = entityManager.createNamedQuery(Pizza.FIND_BY_NAME,Pizza.class);
        query.setParameter("name", name);
        List<Pizza> pizzaList = query.getResultList();
        if (pizzaList.isEmpty()) {
            return null;
        }
        return pizzaList.get(0);
    }
}
