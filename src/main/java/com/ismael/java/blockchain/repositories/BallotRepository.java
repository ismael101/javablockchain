package com.ismael.java.blockchain.repositories;

import java.util.UUID;
import com.ismael.java.blockchain.models.Ballot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BallotRepository extends JpaRepository<Ballot, UUID>{}
