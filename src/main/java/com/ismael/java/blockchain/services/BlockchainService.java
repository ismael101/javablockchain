package com.ismael.java.blockchain.services;

import java.util.ArrayList;
import java.util.List;
import com.ismael.java.blockchain.models.Ballot;
import com.ismael.java.blockchain.models.Block;
import com.ismael.java.blockchain.models.Candidate;
import com.ismael.java.blockchain.repositories.BallotRepository;
import com.ismael.java.blockchain.repositories.BlockRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class BlockchainService {
    BlockRepository blockRepository;
    BallotRepository ballotRepository;
    
    @Autowired
    public BlockchainService(BlockRepository blockRepository, BallotRepository ballotRepository){
        this.blockRepository = blockRepository;
        this.ballotRepository = ballotRepository;
    }
    //check if blocks are linked through previous hashes
    public Boolean validateChain(){
        List<Block> blockchain = blockRepository.findAll();
        for(int x = 1; x<=blockchain.size(); x++){
            if(!blockchain.get(x-1).getHash().equals(blockchain.get(x).getPreviousHash())){
                return false;
            }
        }
        return true;
    }
    //compares block hash and a recalculated hash;
    public Boolean validateBlocks(){
        List<Block> blockchain = blockRepository.findAll();
        for(int x = 0; x<=blockchain.size(); x++){
            if(blockchain.get(x).calculateHash() != blockchain.get(x).getHash()){
                return false;
            }
        }
        return true;
    }
    //checks if their is a duplicate vote
    public Boolean checkVote(Ballot ballot){
        List<Block> blockchain = blockRepository.findAll(); 
        for(Block b : blockchain){
            for(Ballot t: b.getBallots()){
                if(ballot.getPublicKey().equals(t.getPublicKey())){
                    return true;
                }
            }
        }
        return false;
    }
    //collects all ballots in blockchain for a candidate
    public List<Ballot> countBallots(Candidate candidate){
        List<Block> blockchain = blockRepository.findAll();
         List<Ballot> ballots = new ArrayList<Ballot>(); 
        for(Block b : blockchain){
            for(Ballot t: b.getBallots()){
                if(t.getCandidate().equals(candidate)){
                    ballots.add(t);
                }
            }
        }
        return ballots;
    }
    
}
