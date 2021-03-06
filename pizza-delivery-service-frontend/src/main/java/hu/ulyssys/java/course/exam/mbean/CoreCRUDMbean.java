package hu.ulyssys.java.course.exam.mbean;

import hu.ulyssys.java.course.exam.entity.AbstractEntity;
import hu.ulyssys.java.course.exam.entity.AbstractPizza;
import hu.ulyssys.java.course.exam.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractEntity> implements Serializable {
    protected List<T> list;
    protected T selectedEntity;

    protected List<T> selectedList;

    protected CoreService<T> service;


    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        setSelectedEntity(initNewEntity());
        setList(service.getAll());
    }

    public void initEdit(T entity) {
        selectedEntity = entity;
    }


    public void initSave() {
        selectedEntity = initNewEntity();
    }

    public void save() {
        try {
            if (selectedEntity.getId() == null) {
                selectedEntity.setCreateDate(new Date());
                service.add(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));

            } else {
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


    public void remove() {
        try {
            service.remove(selectedEntity);
            list = service.getAll();
            selectedEntity=initNewEntity();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen törlés", null));

        }


    }

    protected abstract String dialogName();

    protected abstract T initNewEntity();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }

    public List<T> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<T> selectedList) {
        this.selectedList = selectedList;
    }
}
