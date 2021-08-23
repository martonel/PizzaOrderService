package hu.ulyssys.java.course.exam.dao;

import hu.ulyssys.java.course.exam.entity.MenuItem;

public interface MenuItemDAO extends CoreDAO<MenuItem> {
    MenuItem findByName(String name);
}
