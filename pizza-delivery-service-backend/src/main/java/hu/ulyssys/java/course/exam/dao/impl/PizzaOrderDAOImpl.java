package hu.ulyssys.java.course.exam.dao.impl;

import hu.ulyssys.java.course.exam.dao.PizzaOrderDAO;
import hu.ulyssys.java.course.exam.entity.PizzaOrder;

import javax.ejb.Stateless;

@Stateless
public class PizzaOrderDAOImpl extends AbstractEntityAwareDAOImpl<PizzaOrder> implements PizzaOrderDAO {
    @Override
    protected Class<PizzaOrder> getManagedClass() {
        return PizzaOrder.class;
    }
}
