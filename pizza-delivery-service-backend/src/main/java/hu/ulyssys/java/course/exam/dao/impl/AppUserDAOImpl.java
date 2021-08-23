package hu.ulyssys.java.course.exam.dao.impl;


import hu.ulyssys.java.course.exam.dao.AppUserDAO;
import hu.ulyssys.java.course.exam.entity.AppUser;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class AppUserDAOImpl extends CoreDAOImpl<AppUser> implements AppUserDAO {

    @Override
    public AppUser findByName(String username) {
        TypedQuery<AppUser> query = entityManager.createNamedQuery(AppUser.FIND_BY_USERNAME, AppUser.class);
        query.setParameter("username", username);
        List<AppUser> appUserList = query.getResultList();
        if (appUserList.isEmpty()) {
            return null;
        }
        return appUserList.get(0);
    }


    @Override
    protected Class<AppUser> getManagedClass() {
        return AppUser.class;
    }
}
