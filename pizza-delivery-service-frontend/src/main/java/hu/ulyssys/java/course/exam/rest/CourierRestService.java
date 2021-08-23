package hu.ulyssys.java.course.exam.rest;

import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.rest.model.CourierModel;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;

import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierModel> {

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }

    @Override
    protected CourierModel initNewModel() {
        return new CourierModel();
    }
}
