package com.ismael.java.blockchain.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ismael.java.blockchain.models.Ballot;
import com.ismael.java.blockchain.services.BallotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/ballot")
public class BallotController {
    private final BallotService service;

    @Autowired
    public BallotController(BallotService service){
        this.service = service;
    }
    @GetMapping
    public List<Ballot> getBallots(){
        return this.service.getBallots();
    }
    @GetMapping("/{id}")
    public Optional<Ballot> getBallot(@PathVariable UUID id){
        return this.service.getBallot(id);
    }

}
