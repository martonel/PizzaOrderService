package hu.ulyssys.java.course.exam.util;

import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;
import hu.ulyssys.java.course.exam.service.PizzaService;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PizzaModelMapperBean extends CoreModelMapperBean<PizzaModel, Pizza> {


    @Override
    public PizzaModel initNewModel() {
        return new PizzaModel();
    }

    @Override
    public PizzaModel createModelFromEntity(Pizza entity) {
        PizzaModel pizzaModel = super.createModelFromEntity(entity);

        pizzaModel.setDescription(entity.getDescription());
        pizzaModel.setName(entity.getName());
        pizzaModel.setValue(entity.getValue());

        return pizzaModel;
    }

    @Override
    public void populateEntityFromModel(Pizza entity, PizzaModel model) {
        super.populateEntityFromModel(entity, model);
        entity.setName(model.getName());
        entity.setValue(model.getValue());
        entity.setDescription(model.getDescription());
    }
}
