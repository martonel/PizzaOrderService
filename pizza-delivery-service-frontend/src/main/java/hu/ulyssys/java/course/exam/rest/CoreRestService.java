package hu.ulyssys.java.course.exam.rest;

import hu.ulyssys.java.course.exam.entity.AbstractPizza;
import hu.ulyssys.java.course.exam.rest.model.CoreRestModel;
import hu.ulyssys.java.course.exam.service.CoreService;
import hu.ulyssys.java.course.exam.service.EntityAwareService;
import hu.ulyssys.java.course.exam.util.CoreModelMapperBean;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.stream.Collectors;

public abstract class CoreRestService<T extends AbstractPizza, M extends CoreRestModel> {

    @Inject
    private CoreService<T> coreService;

    @Inject
    private EntityAwareService<T> entityAwareService;
    @Inject
    private CoreModelMapperBean<M, T> modelMapperBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(coreService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid M model) {

        T entity = initNewEntity();
        populateEntityFromModel(entity, model);
        entity.setCreateDate(new Date());
        coreService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid M model) {
        T entity = coreService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        entity.setModificationDate(new Date());
        coreService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        coreService.remove(entity);
        return Response.ok().build();
    }

    protected void populateEntityFromModel(T entity, M model) {
        modelMapperBean.populateEntityFromModel(entity, model);
    }

    protected M createModelFromEntity(T entity) {
        return modelMapperBean.createModelFromEntity(entity);
    }

     protected T initNewEntity() {
        try {
             Class<T> type = (Class<T>) (((ParameterizedType) ((Class) getClass().getGenericSuperclass()).getGenericSuperclass())).getActualTypeArguments()[1];
            return type.getConstructor().newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected M initNewModel() {
        return modelMapperBean.initNewModel();
    }

}
