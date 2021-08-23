package hu.ulyssys.java.course.exam.mbean;


import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.service.AppUserService;
import hu.ulyssys.java.course.exam.service.CoreService;
import hu.ulyssys.java.course.exam.service.CourierService;
import hu.ulyssys.java.course.exam.service.PizzaService;
import org.primefaces.PrimeFaces;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class CourierCRUDMbean extends CoreAwareCRUDMbean<Courier> implements Serializable  {

    @Inject
    public CourierCRUDMbean(CourierService service, AppUserService userService, LoggedInUserBean loggedInUserBean) {
        super(service, userService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }


}
