package com.ismael.java.blockchain.services;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ismael.java.blockchain.models.Ballot;
import com.ismael.java.blockchain.repositories.BallotRepository;

import org.springframework.beans.factory.annotation.Autowired;


public class BallotService {
    private final BallotRepository repository;

    @Autowired
    public BallotService(BallotRepository repository){
        this.repository = repository;
    }
    //verify signature of ballot with public key
    public boolean verifySignature(Ballot ballot) throws Exception {
        Signature publicSignature = Signature.getInstance("SHA256withRSA");
        publicSignature.initVerify(this.stringToKey(ballot.getPublicKey()));
        publicSignature.update(ballot.getText().getBytes(StandardCharsets.UTF_8));
        byte[] signatureBytes = Base64.getDecoder().decode(ballot.getSignature());
        return publicSignature.verify(signatureBytes);
        
    }
    //convert string to public key
    public PublicKey stringToKey(String keyString) throws NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] keyBytes = Base64.getDecoder().decode(keyString);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec keySpec= new PKCS8EncodedKeySpec(Base64.getDecoder().decode(keyBytes));
        PublicKey publicKey = kf.generatePublic(keySpec);
        return publicKey;
    }
    public List<Ballot> getBallots(){
        return repository.findAll();
    }
    public Optional<Ballot> getBallot(UUID id){
        return repository.findById(id);
    }
    
}
