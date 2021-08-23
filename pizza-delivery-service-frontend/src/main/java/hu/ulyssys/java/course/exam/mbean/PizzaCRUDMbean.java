package hu.ulyssys.java.course.exam.mbean;


import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.service.AppUserService;
import hu.ulyssys.java.course.exam.service.PizzaService;
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
public class PizzaCRUDMbean extends CoreAwareCRUDMbean<Pizza> implements Serializable{

    @Inject
    public PizzaCRUDMbean(PizzaService service, AppUserService userService, LoggedInUserBean loggedInUserBean) {
        super(service, userService);
        if (!loggedInUserBean.isLoggedIn()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }

    @Override
    protected String dialogName() {
        return "pizzaDialog";
    }

    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }
}
