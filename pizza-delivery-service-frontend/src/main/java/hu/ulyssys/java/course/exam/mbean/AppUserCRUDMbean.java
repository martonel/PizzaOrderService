package hu.ulyssys.java.course.exam.mbean;


import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;


@Named
@ViewScoped
public class AppUserCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable{

    @Inject
    public AppUserCRUDMbean(AppUserService service, LoggedInUserBean loggedInUserBean) {
        super(service);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPassword(hashPassword(getSelectedEntity().getPassword()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected String dialogName() {
        return "appUserDialog";
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    private String hashPassword(String rawPassword) {
        return DigestUtils.md5Hex(rawPassword);
    }
}
