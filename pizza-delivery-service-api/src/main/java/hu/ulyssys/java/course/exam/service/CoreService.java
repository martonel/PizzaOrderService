package hu.ulyssys.java.course.exam.service;



import hu.ulyssys.java.course.exam.entity.AbstractEntity;

import java.util.List;

public interface CoreService<T extends AbstractEntity> {
    List<T> getAll();

    T findById(Long id);

    void add(T vehicle);

    void remove(T vehicle);

    void update(T vehicle);
}
