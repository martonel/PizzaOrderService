package hu.ulyssys.java.course.exam.rest;

import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.entity.Courier;
import hu.ulyssys.java.course.exam.entity.Pizza;
import hu.ulyssys.java.course.exam.entity.PizzaOrder;
import hu.ulyssys.java.course.exam.rest.model.AppUserDataModel;
import hu.ulyssys.java.course.exam.rest.model.AppUserModel;
import hu.ulyssys.java.course.exam.service.AppUserService;
import hu.ulyssys.java.course.exam.service.CourierService;
import hu.ulyssys.java.course.exam.service.PizzaOrderService;
import hu.ulyssys.java.course.exam.service.PizzaService;
import hu.ulyssys.java.course.exam.util.CourierModelMapperBean;
import hu.ulyssys.java.course.exam.util.PizzaModelMapperBean;
import hu.ulyssys.java.course.exam.util.PizzaOrderModelMapperBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Path("/appUser")
public class AppUserRestService {


    @Inject
    private AppUserService service;
    @Inject
    private PizzaService pizzaService;
    @Inject
    private CourierService courierService;
    @Inject
    private PizzaOrderService pizzaOrderService;
    @Inject
    private PizzaModelMapperBean pizzaModelMapperBean;
    @Inject
    private CourierModelMapperBean courierModelMapperBean;
    @Inject
    private PizzaOrderModelMapperBean pizzaOrderModelMapperBean;

    @GET
    @Path("/data/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDataById(@PathParam("id") Long id) {
        AppUser appUser = service.findById(id);
        if (appUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();

        }
        //Listányi cat
        List<PizzaOrder> orderList = pizzaOrderService.findByEntityId(id);
        // listányi dog
        List<Courier> courierList = courierService.findByEntityId(id);

        //listányi reinderr
        List<Pizza> pizzaList = pizzaService.findByEntityId(id);
        AppUserDataModel dataModel = new AppUserDataModel();
        dataModel.setId(appUser.getId());
        dataModel.setCreateDate(appUser.getCreateDate());
        dataModel.setUsername(appUser.getUsername());
        dataModel.setPassword(appUser.getPassword());
        dataModel.setRole(appUser.getRole());
        dataModel.setPizzaModels(pizzaModelMapperBean.createModelsFromList(pizzaList));
        dataModel.setCourierModels(courierModelMapperBean.createModelsFromList(courierList));
        dataModel.setPizzaOrderModels(pizzaOrderModelMapperBean.createModelsFromList(orderList));

        return Response.ok(dataModel).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(service.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(AppUserModel model) {
        AppUser appUser = new AppUser();
        appUser.setId(model.getId());
        appUser.setCreateDate(new Date());
        appUser.setUsername(model.getUsername());
        appUser.setPassword(model.getPassword());
        appUser.setRole(model.getRole());
        service.add(appUser);
        return Response.ok(createModelFromEntity(appUser)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(AppUserModel model) {
        AppUser appUser = service.findById(model.getId());
        if (appUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        appUser.setCreateDate(model.getCreateDate());
        appUser.setUsername(model.getUsername());
        appUser.setPassword(model.getPassword());
        appUser.setRole(model.getRole());
        service.update(appUser);
        return Response.ok(createModelFromEntity(appUser)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        AppUser appUser = service.findById(id);
        if (appUser == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        service.remove(appUser);
        return Response.ok().build();
    }

    private AppUserModel createModelFromEntity(AppUser appUser) {
        AppUserModel model = new AppUserModel();
        model.setId(appUser.getId());
        model.setCreateDate(appUser.getCreateDate());
        model.setUsername(appUser.getUsername());
        model.setPassword(appUser.getPassword());
        model.setRole(appUser.getRole());
        return model;
    }
}
