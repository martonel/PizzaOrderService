package hu.ulyssys.java.course.exam.dao;

import hu.ulyssys.java.course.exam.entity.AppUser;

public interface AppUserDAO extends CoreDAO<AppUser>{

    AppUser findByName(String name);

}
