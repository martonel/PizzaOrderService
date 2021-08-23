package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity.MenuItem;
import hu.ulyssys.java.course.exam.service.MenuItemService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class MenuCRUDMbean extends CoreCRUDMbean<MenuItem> implements Serializable {


    @Inject
    public MenuCRUDMbean(MenuItemService menuItemService, LoggedInUserBean loggedInUserBean) {
        super(menuItemService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }
    @Override
    protected String dialogName() {
        return "menuDialog";
    }

    @Override
    public MenuItem initNewEntity() {
        return new MenuItem();
    }

}