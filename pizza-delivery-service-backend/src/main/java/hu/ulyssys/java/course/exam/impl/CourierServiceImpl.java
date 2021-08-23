package hu.ulyssys.java.course.exam.impl;

import hu.ulyssys.java.course.exam.dao.CourierDAO;
import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractEntityServiceImpl<Courier> implements CourierService {

    @Override
    public Courier findByName(String name) {
        return  ((CourierDAO) dao).findByName(name);
    }
}
