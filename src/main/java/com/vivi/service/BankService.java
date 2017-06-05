package com.vivi.service;

import com.vivi.model.Account;

/**
 *
 * @author vivi
 */
public interface BankService {
    public boolean transfer(Account idAccountOrig, Account idAccounDestin, float money);
    public Account getAccountById(long idAccount);
}
