package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity.MenuItem;
import hu.ulyssys.java.course.exam.entity.MenuItemRole;
import hu.ulyssys.java.course.exam.service.MenuItemService;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MenuProviderBean {

    @Inject
    private MenuItemService service;

    @Inject
    private LoggedInUserBean loggedInUserBean;

    public MenuModel getMenuModel() {
        DefaultMenuModel menuModel = new DefaultMenuModel();
        service.getAll().forEach(menuItem -> {
            addMenuItem(menuModel, menuItem);
        });

        return menuModel;
    }

    private void addMenuItem(DefaultMenuModel menuModel, MenuItem item) {

        DefaultMenuItem element = new DefaultMenuItem();
        element.setHref(item.getUrl());
        element.setValue(item.getLabel());

        //isLoggedIn -> be van jelentkezve
        //isAdmin -> admin felhasználóval van bejelentkezve
        //isUser ->User felhasználóval van bejelentkezve
        //item.getAdminFunction()  van-e admin jogosultsága vagy nem az oldalnak

        //minden oldal admin felhasználókkal kivétel user felhasználói oldalakat
        //user oldal user felhasználókkal

        //kombinációk
        //igaz hamis hogy admin-e 2 érték
        //lehet kijelentkezve, admin, user, bejelentkezve bárki
        //null - admin - user - isLoggedIn

        if(item.getAdminFunction().equals(MenuItemRole.USER) && loggedInUserBean.isUser()){
            menuModel.getElements().add(element);
        }
        if(item.getAdminFunction().equals(MenuItemRole.ADMIN) && loggedInUserBean.isAdmin()){
            menuModel.getElements().add(element);
        }
        if(item.getAdminFunction().equals(MenuItemRole.BOTH) && loggedInUserBean.isLoggedIn()){
            menuModel.getElements().add(element);
        }
        //ahoz hogy ne látszódjon alapból  item.getAdminFunction() != null kellene, de azzal nem megy

    }
}