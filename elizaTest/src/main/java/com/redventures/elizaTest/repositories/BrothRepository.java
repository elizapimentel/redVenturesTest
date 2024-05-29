package com.redventures.elizaTest.repositories;

import com.redventures.elizaTest.model.Broth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BrothRepository extends JpaRepository<Broth, UUID> {
}
