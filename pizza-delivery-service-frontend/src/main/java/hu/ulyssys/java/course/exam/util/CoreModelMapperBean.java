package hu.ulyssys.java.course.exam.util;

import hu.ulyssys.java.course.exam.entity.AbstractPizza;
import hu.ulyssys.java.course.exam.rest.model.CoreRestModel;
import hu.ulyssys.java.course.exam.service.AppUserService;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractPizza> {

    @Inject
    private AppUserService userService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setCreateDate(entity.getCreateDate());
        model.setId(entity.getId());
        model.setModificationDate(entity.getModificationDate());
        if (entity.getCreator() != null) {
            model.setEntityID(entity.getCreator().getId());
        }
        if(entity.getModifierUser() !=null){
            model.setEntityID(entity.getModifierUser().getId());
        }
        return model;
    }

    public List<M> createModelsFromList(List<T> entity) {
        return entity.stream().map(this::createModelFromEntity).collect(Collectors.toList());
    }

    public void populateEntityFromModel(T entity, M model) {
        if (model.getId() != null) {
            entity.setCreator(userService.findById(model.getEntityID()));
            entity.setModifierUser(userService.findById(model.getEntityID()));
        }
        entity.setId(model.getId());
        entity.setCreateDate(model.getCreateDate());
        entity.setModificationDate(model.getModificationDate());
    }

    public abstract M initNewModel();

}
