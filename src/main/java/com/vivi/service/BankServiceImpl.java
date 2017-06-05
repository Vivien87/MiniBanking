package com.vivi.service;

import com.vivi.dao.BankDAO;
import com.vivi.model.Account;
import static com.vivi.service.AddMovements.setMovements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vivi
 */
@Service
@Transactional
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDAO bankDao;

    private boolean removeBalance(Account account, float balance) {
        if (account.getBalance() >= balance) {
            account.setBalance(account.getBalance() - balance);
            return true;
        } else {
            
            return false;
        }
    }

    private void depositBalance(Account account, float balance) {
        account.setBalance(account.getBalance() + balance);
    }

   
    public boolean transfer(Account accountOrig, Account accountDestin, float money) {
        
        if (removeBalance(accountOrig, money)) {
            
            depositBalance(accountDestin, money);
         
            accountOrig.addMovements(setMovements("Upload_Transfer", accountDestin.getId(), money));
            accountDestin.addMovements(setMovements("Received Transfer", accountOrig.getId(),money));  
        
            bankDao.update(accountOrig);
            bankDao.update(accountDestin);
            return true;
        } else {
            return false;
        }
    }

   
    public Account getAccountById(long idAccount) {
        return bankDao.getAccountById(idAccount);
    }

}
