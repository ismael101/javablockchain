package com.ismael.java.blockchain.repositories;

import java.util.UUID;
import com.ismael.java.blockchain.models.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends JpaRepository<Block, UUID>{}

