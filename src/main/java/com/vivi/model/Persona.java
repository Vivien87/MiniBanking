package com.vivi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;

@Entity
public class Persona implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long personaId;
    private String lastName;
    private String id;
    private String firstName;
    private String phone;

    public Persona() {
    }

    public Persona(long personaId, String lastName, String id, String firstName, String phoneo) {
        this.personaId = personaId;
        this.lastName = lastName;
        this.id = id;
        this.firstName = firstName;
        this.phone = phone;
    }

    public long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(long personaId) {
        this.personaId = personaId;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
