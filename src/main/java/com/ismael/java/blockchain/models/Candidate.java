package com.ismael.java.blockchain.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Candidate {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    public Candidate(){}
    public Candidate(String name){
        this.name = name;
    }
    public UUID getId() {
        return id;
    };
    public void setId(UUID id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
