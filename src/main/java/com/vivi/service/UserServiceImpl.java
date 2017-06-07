package com.vivi.service;

import com.vivi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vivi.dao.UserDAO;
import com.vivi.model.Account;
import com.vivi.model.User_Role;
import static com.vivi.service.AddMovements.setMovements;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public void create(User user) {

        Account account = new Account();
        account.setBalance(0);
        account.addMovements(setMovements("Registr",0,0));
        user.setAccount(account);

        user.setRole(User_Role.ROLE_USER);

        userDao.create(user);
    }

    @Override
    public User getUserByUsername(String username) {

        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

}
