package hu.ulyssys.java.course.exam.rest.model;

import java.util.List;

public class AppUserDataModel extends AppUserModel {

    private List<CourierModel> courierModels;
    private List<PizzaModel> pizzaModels;
    private List<PizzaOrderModel> pizzaOrderModels;

    public List<CourierModel> getCourierModels() {
        return courierModels;
    }

    public void setCourierModels(List<CourierModel> courierModels) {
        this.courierModels = courierModels;
    }

    public List<PizzaModel> getPizzaModels() {
        return pizzaModels;
    }

    public void setPizzaModels(List<PizzaModel> pizzaModels) {
        this.pizzaModels = pizzaModels;
    }

    public List<PizzaOrderModel> getPizzaOrderModels() {
        return pizzaOrderModels;
    }

    public void setPizzaOrderModels(List<PizzaOrderModel> pizzaOrderModels) {
        this.pizzaOrderModels = pizzaOrderModels;
    }
}
