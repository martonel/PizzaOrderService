package hu.ulyssys.java.course.exam.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQuery(name = MenuItem.FIND_BY_NAME,query = "select p from MenuItem p where p.url=:url")
@Table
@Entity
public class MenuItem extends AbstractEntity {

    public static final String FIND_BY_NAME = "MenuItem.findByName";
    private String url;
    private String label;
    private MenuItemRole adminFunction;

    public static String getFindByName() {
        return FIND_BY_NAME;
    }

    public MenuItemRole getAdminFunction() {
        return adminFunction;
    }

    public void setAdminFunction(MenuItemRole adminFunction) {
        this.adminFunction = adminFunction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



}
