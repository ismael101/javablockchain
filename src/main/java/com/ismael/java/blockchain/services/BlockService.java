package com.ismael.java.blockchain.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.ismael.java.blockchain.models.Block;
import com.ismael.java.blockchain.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlockService {
    private final BlockRepository repository;

    @Autowired
    public BlockService(BlockRepository repository){
        this.repository = repository;
    }
    //searches for a hash beginning with a zeros multiplied by difficulty
    public void mineBlock(Block block, Integer difficulty){
        String mineString = new String(new char[difficulty]).replace("\0", "0");
        while(!block.getHash().substring(0, difficulty).equals(mineString)){
            block.setNonce(block.getNonce() + 1);
            block.setHash(block.calculateHash());
        }
    }
    public List<Block> getBlocks(){
        return repository.findAll();
    }
    public Optional<Block> getBlock(UUID id){
        return repository.findById(id);   
    }
    public void addBlock(Block block){
        this.mineBlock(block, Integer.parseInt(System.getenv("DIFFICULTY")));
        repository.save(block);
    }
}
