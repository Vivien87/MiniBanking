
package com.vivi.dao;

import com.vivi.model.Account;

/**
 *
 * @author vivi
 */
public interface BankDAO {

    Account getAccountById(long idAccount);

    void update(Account account);

}
