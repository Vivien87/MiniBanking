package com.vivi.dao;

import com.vivi.model.User;
import java.util.List;

/**
 *
 * @author vivi 
 */
public interface UserDAO  {

    void create(User user);

    void delete(User user);


    void update(User user);
    
    User getUserByUsername(String username);
    User getUserById(long id);
    
     List<User> getAll();
    
}
