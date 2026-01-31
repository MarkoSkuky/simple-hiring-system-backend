package com.marko.hiringSystem.repository;

import com.marko.hiringSystem.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}
