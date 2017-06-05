package com.vivi.dao;

import com.vivi.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * 
 */
@Repository
public class BankDAOImpl implements BankDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

   
    public Account getAccountById(long idAccount) {
        return (Account) getCurrentSession().createQuery("FROM com.banco.model.AccountWHERE cuentaId='" + idAccount + "'").uniqueResult();

    }

   
    public void update(Account  account) {
        getCurrentSession().update(account);
    }

}
