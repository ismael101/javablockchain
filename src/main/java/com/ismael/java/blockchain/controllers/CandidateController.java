package com.ismael.java.blockchain.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ismael.java.blockchain.models.Candidate;
import com.ismael.java.blockchain.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path = "api/v1/candidate")
public class CandidateController {
    private final CandidateService service;

    @Autowired
    public CandidateController(CandidateService service){
        this.service = service;
    }
    @GetMapping
    public List<Candidate> getCandidates(){
        return this.service.getCandidates();
    }
    @GetMapping("/{id}")
    public Optional<Candidate> getCandidate(@PathVariable UUID id){
            return this.service.getCandidate(id);
    }

}
