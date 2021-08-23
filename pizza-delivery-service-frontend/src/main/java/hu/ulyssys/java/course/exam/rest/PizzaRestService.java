package hu.ulyssys.java.course.exam.rest;

import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;

import javax.ws.rs.Path;

@Path("/pizza")
public class PizzaRestService extends CoreRestService<Pizza, PizzaModel> {

    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }

    @Override
    protected PizzaModel initNewModel() {
        return new PizzaModel();
    }
}
