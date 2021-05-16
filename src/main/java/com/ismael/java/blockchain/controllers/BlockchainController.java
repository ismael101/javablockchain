package com.ismael.java.blockchain.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.ismael.java.blockchain.models.Ballot;
import com.ismael.java.blockchain.models.Candidate;
import com.ismael.java.blockchain.repositories.CandidateRepository;
import com.ismael.java.blockchain.services.BlockchainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/blockchain")
public class BlockchainController {
    BlockchainService service;
    CandidateRepository candidateRepository;

    @Autowired
    public BlockchainController(BlockchainService service, CandidateRepository candidateRepository){
        this.service = service;
        this.candidateRepository = candidateRepository;
    }
    @GetMapping("/valid")
    public Boolean check(){
        if(this.service.validateBlocks() && this.service.validateChain()){
            return true;
        }
        return false;
    }
    @GetMapping("/count")
    public HashMap<UUID, List<Ballot>>  countBallots(){
        List<Candidate> candidates = this.candidateRepository.findAll();
        HashMap<UUID, List<Ballot>> count = new HashMap<UUID, List<Ballot>>();
        for(Candidate c : candidates){
            List<Ballot>  ballots = this.service.countBallots(c);
            count.put(c.getId(), ballots);
        }
        return count;
    }
       
}
