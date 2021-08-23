package hu.ulyssys.java.course.exam.service;

import hu.ulyssys.java.course.exam.entity.Courier;

public interface CourierService extends CoreService<Courier>, EntityAwareService<Courier> {
    Courier findByName(String name);
}
