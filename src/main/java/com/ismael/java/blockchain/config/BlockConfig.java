package com.ismael.java.blockchain.config;

import java.util.Collections;
import java.util.List;

import com.ismael.java.blockchain.models.Block;
import com.ismael.java.blockchain.models.Candidate;
import com.ismael.java.blockchain.models.Ballot;
import com.ismael.java.blockchain.repositories.BlockRepository;
import com.ismael.java.blockchain.repositories.CandidateRepository;
import com.ismael.java.blockchain.services.BlockService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlockConfig {
    @Bean
    CommandLineRunner commandLineRunner(BlockRepository blockRepository, BlockService blockService, CandidateRepository candidateRepository){
        return args -> {
            Block genesisBlock = new Block(0, "",Collections.<Ballot>emptyList());
            blockService.addBlock(genesisBlock);
            Candidate candidate1 = new Candidate("John Smith");
            Candidate candidate2 = new Candidate("Jane Jackson");
            Candidate candidate3 = new Candidate("Sarah lin");
            candidateRepository.saveAll(List.of(candidate1, candidate2, candidate3));
        };
    }
}
