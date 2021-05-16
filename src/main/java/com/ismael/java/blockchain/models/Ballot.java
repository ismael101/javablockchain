package com.ismael.java.blockchain.models;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ballot {
    @Id
    @GeneratedValue
    private UUID id;
    //publickey of voter to confirm ballot
    private String publicKey;
    //signature used to verify ballot
    private String signature;
    //text signed by private key to create signature
    private String text;
    @OneToMany
    private Candidate candidate;

    public Ballot(){}
    public Ballot(String publicKey, String signature, String text, Candidate candidate){
        this.publicKey = publicKey;
        this.signature = signature;
        this.text = text;
        this.candidate = candidate;
    }  
    public String getPublicKey() {
        return publicKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Candidate getCandidate() {
        return candidate;
    }
    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
    @Override
    public String toString() {
        return this.id.toString() + 
        this.publicKey +
        this.signature + 
        this.candidate.toString();
    }

}
