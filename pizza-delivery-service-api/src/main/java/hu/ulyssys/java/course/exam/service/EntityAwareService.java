package hu.ulyssys.java.course.exam.service;

import hu.ulyssys.java.course.exam.entity.AbstractPizza;
import java.util.List;

public interface EntityAwareService<T extends AbstractPizza> {
    //ez a rákövető id-ja
    List<T> findByEntityId(Long id);
}
