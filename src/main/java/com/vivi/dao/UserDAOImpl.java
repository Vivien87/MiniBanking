package com.vivi.dao;

import com.vivi.model.User;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vivi
 */
@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

   
    public void create(User user) {
        getCurrentSession().save(user);
    }


  
    public void update(User user) {
        getCurrentSession().update(user);
        
    }
    

   
    public void delete(User user) {
        getCurrentSession().delete(user);
    }

    
    public User getUserByUsername(String username) {
        return (User) getCurrentSession().createQuery("FROM com.vivi.model.User WHERE username='" + username + "'").uniqueResult();
    }

    
    public List<User> getAll() {
        List<User> lst = new ArrayList<User>();
        lst = getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return lst;
    }

   
    public User getUserById(long id) {
    User user = (User) getCurrentSession().get(User.class, id);
    return user;
    }

}
