package com.vivi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account<Movimientos> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;
    private float balance;
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Movements> movements = new ArrayList<Movements>();

    public Account() {
    }

    public Account(long accountId, float balance) {
        this.accountId = accountId;
        this.balance = balance;
    }
    
  
    public long getId() {
        return accountId;
    }

    public void setId(long id) {
        this.accountId = id;
    }
    

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getBalance() {
        return balance;
    }

    public List<Movements> getMovements() {
        Collections.reverse(this.movements);
        return movements;
    }

    public void setMovements(List<Movements> movements) {
        this.movements = movements;
    }

    
    public void addMovements(Movements mov){
        this.movements.add(mov);
    }


}
