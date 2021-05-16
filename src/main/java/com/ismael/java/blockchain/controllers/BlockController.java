package com.ismael.java.blockchain.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.ismael.java.blockchain.models.Block;
import com.ismael.java.blockchain.services.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/block")
public class BlockController {
    private final BlockService service;

    @Autowired
    public BlockController(BlockService service){
        this.service = service;
    }
    @GetMapping
    public List<Block> getBlocks(){
        return this.service.getBlocks();
    }
    @GetMapping("/{id}")
    public Optional<Block> getCandidate(@PathVariable UUID id){
            return this.service.getBlock(id);
    }
}
