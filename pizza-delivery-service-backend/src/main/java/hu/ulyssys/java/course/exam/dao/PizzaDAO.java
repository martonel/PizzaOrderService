package hu.ulyssys.java.course.exam.dao;

import hu.ulyssys.java.course.exam.entity.Pizza;

public interface PizzaDAO extends EntityAwareDAO<Pizza> {
    Pizza findByName(String name);

}
