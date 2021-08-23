package hu.ulyssys.java.course.exam.util;

import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.rest.model.CourierModel;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CourierModelMapperBean extends CoreModelMapperBean<CourierModel, Courier> {

    @Override
    public CourierModel createModelFromEntity(Courier entity) {
        CourierModel courierModel = super.createModelFromEntity(entity);
        courierModel.setFirstName(entity.getFirstName());
        courierModel.setLastName(entity.getLastName());
        courierModel.setPhoneNumber(entity.getPhoneNumber());
        return courierModel;
    }

    @Override
    public void populateEntityFromModel(Courier entity, CourierModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setPhoneNumber(model.getPhoneNumber());
    }
    @Override
    public CourierModel initNewModel() {
        return new CourierModel();
    }
}
