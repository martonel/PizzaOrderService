package hu.ulyssys.java.course.exam.entity;
import javax.persistence.*;
import java.util.Objects;

@NamedQuery(name = Pizza.FIND_BY_NAME,query = "select p from Pizza p where p.name=:name")
@Entity
@Table
public class Pizza extends AbstractPizza{
    public static final String FIND_BY_NAME = "Pizza.findByName";

    @Column(name="name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (getId() != null ? !getId().equals(pizza.getId()) : pizza.getId() != null) return false;
        return name != null ? name.equals(pizza.name) : pizza.name == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
