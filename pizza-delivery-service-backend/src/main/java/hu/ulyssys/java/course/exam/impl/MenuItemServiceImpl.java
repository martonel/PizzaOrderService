package hu.ulyssys.java.course.exam.impl;

import hu.ulyssys.java.course.exam.dao.MenuItemDAO;
import hu.ulyssys.java.course.exam.dao.PizzaDAO;
import hu.ulyssys.java.course.exam.entity.MenuItem;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.service.MenuItemService;

import javax.ejb.Stateless;

@Stateless
public class MenuItemServiceImpl extends AbstractServiceImpl<MenuItem> implements MenuItemService {
    @Override
    public MenuItem findByName(String name) {
        return ((MenuItemDAO) dao).findByName(name);
    }
}
