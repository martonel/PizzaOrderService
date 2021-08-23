package hu.ulyssys.java.course.exam.service;

import hu.ulyssys.java.course.exam.entity.AppUser;

public interface AppUserService extends CoreService<AppUser>{
        AppUser findByName(String name);
}