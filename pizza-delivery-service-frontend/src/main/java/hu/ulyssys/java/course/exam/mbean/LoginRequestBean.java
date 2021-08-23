package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.exam.mbean.model.LoginModel;
import hu.ulyssys.java.course.exam.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequestBean {

    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserBean bean;

    @Inject
    private AppUserService userService;

    public void doLogin() {

        try {
            //Ha sikeres a login
            AppUser appUser = getLoginStatus();
            if (appUser == null) {
                throw new SecurityException("Nem létező felhasználó");
            }
            String hashedPassword = DigestUtils.md5Hex(model.getPassword());
            if (!hashedPassword.equals(appUser.getPassword())) {
                throw new SecurityException("Nem megfelelő jelszó");
            }
            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(appUser.getUsername());
            loggedInUserModel.setId(appUser.getId());
            loggedInUserModel.setRole(appUser.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");
        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "sikertelen bejelentkezés", ""));
        }
    }

    public void doLogout() {
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }

    public AppUser getLoginStatus(){
        return userService.findByName(model.getUsername());
    }

}
