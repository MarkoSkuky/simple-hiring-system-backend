package com.marko.hiringSystem.repository;

import com.marko.hiringSystem.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    void deleteByCandidateId(Long candidateId);
}
