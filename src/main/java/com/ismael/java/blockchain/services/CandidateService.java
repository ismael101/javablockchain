package com.ismael.java.blockchain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.ismael.java.blockchain.models.Candidate;
import com.ismael.java.blockchain.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {
    private final CandidateRepository repository;
    
    @Autowired
    public CandidateService(CandidateRepository repository){
        this.repository = repository;
    }
    public List<Candidate> getCandidates(){
        return repository.findAll();
    }
    public Optional<Candidate> getCandidate(UUID id){
        return repository.findById(id);
    }
}
