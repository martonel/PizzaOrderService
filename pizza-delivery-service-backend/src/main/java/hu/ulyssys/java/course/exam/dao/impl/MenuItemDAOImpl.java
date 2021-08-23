package hu.ulyssys.java.course.exam.dao.impl;

import hu.ulyssys.java.course.exam.dao.MenuItemDAO;
import hu.ulyssys.java.course.exam.entity.MenuItem;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class MenuItemDAOImpl extends CoreDAOImpl<MenuItem> implements MenuItemDAO {
    @Override
    protected Class<MenuItem> getManagedClass() {
        return MenuItem.class;
    }

    @Override
    public MenuItem findByName(String url) {
        TypedQuery<MenuItem> query = entityManager.createNamedQuery(MenuItem.FIND_BY_NAME,MenuItem.class);
        query.setParameter("url", url);
        List<MenuItem> menuItemList = query.getResultList();
        if (menuItemList.isEmpty()) {
            return null;
        }
        return menuItemList.get(0);
    }
}
