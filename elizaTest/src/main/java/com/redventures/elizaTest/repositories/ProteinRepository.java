package com.redventures.elizaTest.repositories;

import com.redventures.elizaTest.model.Protein;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, Long> {
}
