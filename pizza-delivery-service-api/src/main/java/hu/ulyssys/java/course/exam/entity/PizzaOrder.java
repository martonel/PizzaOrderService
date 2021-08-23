package hu.ulyssys.java.course.exam.entity;

import javax.persistence.*;

@Entity
@Table
public class PizzaOrder extends AbstractPizza{

    @JoinColumn(name = "pizza_id")
    @ManyToOne
    private Pizza pizza;

    @JoinColumn(name = "courier_id")
    @ManyToOne
    private Courier courier;

    @Column(name = "settlement")
    private String settlement;

    @Column(name = "public_space")
    private String publicSpace;

    @Enumerated(EnumType.STRING)
    @Column(name = "public_space_type")
    private PublicSpaceType publicSpaceType;

    @Column(name = "house_number")
    private String houseNumber;

    public String getSettlement() {
        return settlement;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
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

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public PublicSpaceType getPublicSpaceType() {
        return publicSpaceType;
    }

    public void setPublicSpaceType(PublicSpaceType publicSpaceType) {
        this.publicSpaceType = publicSpaceType;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

}
