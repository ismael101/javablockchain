package com.ismael.java.blockchain.models;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Block {
    @Id
    @GeneratedValue
    private UUID id;
    //position in list
    private Integer index;
    //hash of block information
    private String hash;
    //hash of previous block
    private String previousHash;
    //timestamp when block is created
    private Timestamp timestamp;
    //mutable number used to mine block
    private Integer nonce;
    //this election the block is linked to
    @OneToMany(targetEntity = Ballot.class)
    private List<Ballot> ballots;

    public Block(){}
    public Block(Integer index, String previousHash, List<Ballot> ballots){
        this.index = index;
        this.previousHash = previousHash;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.ballots = ballots;
        this.nonce = 0;
        this.hash = this.calculateHash();
    }
    public String calculateHash(){
        String hash = null;
        try{
            //create a string that contains the all the information in the block
            String originalString = this.id.toString() +
            Integer.toString(this.getIndex()) + 
            this.getBallots().toString() + 
            this.getTimestamp().toString() + 
            this.getPreviousHash() + 
            Integer.toString(this.getNonce());
            MessageDigest digest = MessageDigest.getInstance("SHA3-256");
            byte[] hashbytes = digest.digest(
            originalString.getBytes(StandardCharsets.UTF_8));
            hash = new String(Base64.getEncoder().encodeToString(hashbytes));
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        return hash;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public Integer getIndex() {
        return index;
    }
    public void setIndex(Integer index) {
        this.index = index;
    }
    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getPreviousHash() {
        return previousHash;
    }
    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }
    public Timestamp getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
    public Integer getNonce() {
        return nonce;
    }
    public void setNonce(Integer nonce) {
        this.nonce = nonce;
    }
    public List<Ballot> getBallots() {
        return ballots;
    }
    public void setBallots(List<Ballot> ballots) {
        this.ballots = ballots;
    }
}
