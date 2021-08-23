package hu.ulyssys.java.course.exam.rest.model;

import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.entity.PublicSpaceType;

import javax.persistence.*;

public class PizzaOrderModel extends CoreRestModel{
    private Pizza pizza;
    private Courier courier;
    private String settlement;
    private String publicSpace;
    private PublicSpaceType publicSpaceType;
    private String houseNumber;

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    public String getPublicSpace() {
        return publicSpace;
    }

    public void setPublicSpace(String publicSpace) {
        this.publicSpace = publicSpace;
    }

    public PublicSpaceType getPublicSpaceType() {
        return publicSpaceType;
    }

    public void setPublicSpaceType(PublicSpaceType publicSpaceType) {
        this.publicSpaceType = publicSpaceType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }
}
