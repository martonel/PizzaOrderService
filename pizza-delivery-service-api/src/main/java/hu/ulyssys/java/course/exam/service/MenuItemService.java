package hu.ulyssys.java.course.exam.service;

import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.MenuItem;
import hu.ulyssys.java.course.exam.entity.Pizza;

public interface MenuItemService extends CoreService<MenuItem> {
    MenuItem findByName(String name);
}
