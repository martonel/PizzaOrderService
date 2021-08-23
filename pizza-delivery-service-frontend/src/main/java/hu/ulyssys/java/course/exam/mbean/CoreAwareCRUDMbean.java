package hu.ulyssys.java.course.exam.mbean;


import hu.ulyssys.java.course.exam.entity.*;
import hu.ulyssys.java.course.exam.mbean.model.LoggedInUserModel;
import hu.ulyssys.java.course.exam.service.*;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

public abstract class CoreAwareCRUDMbean<T extends AbstractPizza> extends CoreCRUDMbean<T> {
    private List<AppUser> userList;

    @Inject
    public CoreAwareCRUDMbean(CoreService<T> service) {
        super(service);
    }

    @Inject
    private AppUserService userService;

    @Inject
    protected LoggedInUserBean loggedInUserBean;

    private AppUser appUser;


    public CoreAwareCRUDMbean(CoreService<T> service, AppUserService userService) {
        super(service);
        userList = userService.getAll();
    }
    public List<AppUser> getUserList() {
        return userList;
    }

    public void setUserList(List<AppUser> userList) {
        this.userList = userList;
    }

    protected LoggedInUserModel user;
    @Override
    public void save() {
        try {
            if(loggedInUserBean !=null && userService!=null) {
                user = loggedInUserBean.getModel();
                appUser = userService.findByName(loggedInUserBean.getModel().getUsername());
            }
            if (selectedEntity.getId() == null) {
                selectedEntity.setCreateDate(new Date());
                selectedEntity.setCreator(appUser);
                service.add(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));

            } else {
                selectedEntity.setModificationDate(new Date());
                selectedEntity.setModifierUser(appUser);
                service.update(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
            }
            PrimeFaces.current().executeScript("PF('" + dialogName() + "').hide()");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés", null));
        }
    }

}
