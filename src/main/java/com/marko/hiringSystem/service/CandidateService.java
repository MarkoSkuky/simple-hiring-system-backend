package com.marko.hiringSystem.service;

import com.marko.hiringSystem.entity.Candidate;
import com.marko.hiringSystem.repository.CandidateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateService(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    public Candidate createCandidate(Candidate candidate) {
        return this.candidateRepository.save(candidate);
    }

    public List<Candidate> getAllCandidates() {
        return this.candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return this.candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

}
