package hu.ulyssys.java.course.exam.rest.model;

import javax.persistence.Column;

public class PizzaModel extends CoreRestModel{
    private String name;
    private String description;
    private Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
