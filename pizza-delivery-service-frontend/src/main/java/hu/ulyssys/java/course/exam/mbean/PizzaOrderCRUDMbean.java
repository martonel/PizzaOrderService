package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity
        .AppUser;
import hu.ulyssys.java.course.exam.entity.PizzaOrder;
import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.service.*;
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
public class PizzaOrderCRUDMbean extends CoreAwareCRUDMbean<PizzaOrder> implements Serializable {

    private List<Pizza> pizzaList;

    private List<Courier> courierList;

    private String loginModel;
    @Inject
    public PizzaOrderCRUDMbean(CoreService<PizzaOrder> service, AppUserService userService, PizzaService pizzaService, CourierService courierService,LoggedInUserBean loggedInUserBean) {
        super(service, userService);
        pizzaList = pizzaService.getAll();
        courierList = courierService.getAll();
        loginModel = loggedInUserBean.getModel().getUsername();
        //SetSelectedList();
        if (!loggedInUserBean.isLoggedIn()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }

    @Override
    protected String dialogName() {
        return "pizzaOrderDialog";
    }

    @Override
    protected PizzaOrder initNewEntity() {
        return new PizzaOrder();
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }


    @Override
    public void initEdit(PizzaOrder entity) {

    }

    @Override
    public void initSave() {
        super.initSave();
    }

    public void SetSelectedList(){
        for (PizzaOrder order : service.getAll()) {
            /*if (!loginModel.isEmpty()) {
                if (order.getCreator().getUsername().equals(loginModel)) {
                    selectedList.add(order);
                }
            }
             */
            selectedList.add(order);
        }
    }

}
