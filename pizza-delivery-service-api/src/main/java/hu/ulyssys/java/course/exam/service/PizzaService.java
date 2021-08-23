package hu.ulyssys.java.course.exam.service;

import hu.ulyssys.java.course.exam.entity.Pizza;

public interface PizzaService extends CoreService<Pizza>, EntityAwareService<Pizza> {
    Pizza findByName(String name);
}
