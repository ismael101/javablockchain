package com.ismael.java.blockchain.repositories;

import java.util.UUID;
import com.ismael.java.blockchain.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, UUID>{}