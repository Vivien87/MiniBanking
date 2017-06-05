package com.vivi.security;

import com.vivi.model.User_Role;
import com.vivi.model.User;
import org.springframework.security.core.authority.AuthorityUtils;

/**
 *
 * @author vivi
 */
public class CurrentUser extends org.springframework.security.core.userdetails.User{
    
    private User user;
    
    public CurrentUser(User user){
        super(user.getUsername(),user.getPassword(),AuthorityUtils.createAuthorityList(user.getRole().toString()));
        this.user = user;
    }
    
    public User getUser(){
        return user;
    }
    
    public User_Role getRole(){
        return user.getRole();
    }
}
