package hu.ulyssys.java.course.exam.util;

import hu.ulyssys.java.course.exam.entity.PizzaOrder;
import hu.ulyssys.java.course.exam.rest.model.PizzaModel;
import hu.ulyssys.java.course.exam.rest.model.PizzaOrderModel;
import hu.ulyssys.java.course.exam.service.AppUserService;
import hu.ulyssys.java.course.exam.service.CourierService;
import hu.ulyssys.java.course.exam.service.PizzaOrderService;
import hu.ulyssys.java.course.exam.service.PizzaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PizzaOrderModelMapperBean extends CoreModelMapperBean<PizzaOrderModel, PizzaOrder> {

    @Inject
    private PizzaService pizzaService;

    @Inject
    private CourierService courierService;

    @Override
    public PizzaOrderModel createModelFromEntity(PizzaOrder entity) {
        PizzaOrderModel pizzaOrderModel = super.createModelFromEntity(entity);
        if (entity.getPizza() != null) {
            pizzaOrderModel.setEntityID(entity.getPizza().getId());
        }
        if(entity.getCourier()!=null){
            pizzaOrderModel.setEntityID(entity.getCourier().getId());
        }
        pizzaOrderModel.setSettlement(entity.getSettlement());
        pizzaOrderModel.setPublicSpace(entity.getPublicSpace());
        pizzaOrderModel.setPublicSpaceType(entity.getPublicSpaceType());
        pizzaOrderModel.setHouseNumber(entity.getHouseNumber());
        return pizzaOrderModel;
    }

    @Override
    public void populateEntityFromModel(PizzaOrder entity, PizzaOrderModel model) {
        super.populateEntityFromModel(entity, model);
        if (model.getId() != null) {
            entity.setPizza(pizzaService.findById(model.getEntityID()));
            entity.setCourier(courierService.findById(model.getEntityID()));
        }
        entity.setSettlement(model.getSettlement());
        entity.setPublicSpace(model.getPublicSpace());
        entity.setPublicSpaceType(model.getPublicSpaceType());
        entity.setHouseNumber(model.getHouseNumber());
    }

    @Override
    public PizzaOrderModel initNewModel() {
        return new PizzaOrderModel();
    }
}
