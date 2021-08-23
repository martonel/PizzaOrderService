package hu.ulyssys.java.course.exam.converter;


import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.service.AppUserService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class AppUserConverter implements Converter {

    @Inject
    private AppUserService appUserService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        //SQL query lesz majd, findByName
        return appUserService.findByName(s);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof AppUser) {
            return ((AppUser) o).getUsername();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}
