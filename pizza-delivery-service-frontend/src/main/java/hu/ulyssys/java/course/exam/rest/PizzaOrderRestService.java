package hu.ulyssys.java.course.exam.rest;

import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.entity.PizzaOrder;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;
import hu.ulyssys.java.course.exam.rest.model.PizzaOrderModel;

import javax.ws.rs.Path;

@Path("/pizzaOrder")
public class PizzaOrderRestService extends CoreRestService<PizzaOrder, PizzaOrderModel> {

    @Override
    protected PizzaOrder initNewEntity() {
        return new PizzaOrder();
    }

    @Override
    protected PizzaOrderModel initNewModel() {
        return new PizzaOrderModel();
    }
}
