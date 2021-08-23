package hu.ulyssys.java.course.exam.impl;

import hu.ulyssys.java.course.exam.dao.AppUserDAO;
import hu.ulyssys.java.course.exam.entity.AppUser;
import hu.ulyssys.java.course.exam.service.AppUserService;

import javax.ejb.Stateless;

@Stateless
public class AppUserServiceImpl extends AbstractServiceImpl<AppUser> implements AppUserService {

    @Override
    public AppUser findByName(String name) {
        return  ((AppUserDAO) dao).findByName(name);
    }
}
