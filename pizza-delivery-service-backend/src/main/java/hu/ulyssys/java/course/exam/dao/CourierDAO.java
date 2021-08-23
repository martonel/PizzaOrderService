package hu.ulyssys.java.course.exam.dao;

import hu.ulyssys.java.course.exam.entity.Courier;

public interface CourierDAO extends EntityAwareDAO<Courier> {
    Courier findByName(String name);
}
