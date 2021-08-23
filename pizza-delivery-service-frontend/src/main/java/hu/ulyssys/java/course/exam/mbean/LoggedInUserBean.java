package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity.AppUserRole;
import hu.ulyssys.java.course.exam.mbean.model.LoggedInUserModel;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class LoggedInUserBean implements Serializable {

    private LoggedInUserModel model;

    public LoggedInUserModel getModel() {
        return model;
    }

    public void setModel(LoggedInUserModel model) {
        this.model = model;
    }

    public boolean isLoggedIn() {
        return model != null;
    }

    public boolean isAdmin() {
        return isLoggedIn() && model.getRole().equals(AppUserRole.ADMIN);
    }

    public boolean isUser(){
        return isLoggedIn() && model.getRole().equals(AppUserRole.USER);
    }
}
