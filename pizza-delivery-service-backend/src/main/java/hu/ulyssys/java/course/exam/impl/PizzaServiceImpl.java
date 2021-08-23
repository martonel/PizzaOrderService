package hu.ulyssys.java.course.exam.impl;


import hu.ulyssys.java.course.exam.dao.PizzaDAO;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.service.PizzaService;

import javax.ejb.Stateless;

@Stateless
public class PizzaServiceImpl extends AbstractEntityServiceImpl<Pizza> implements PizzaService {

    @Override
    public Pizza findByName(String name) {
        return  ((PizzaDAO) dao).findByName(name);
    }
}
