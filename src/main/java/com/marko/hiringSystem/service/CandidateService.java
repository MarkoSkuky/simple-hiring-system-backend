package com.marko.hiringSystem.service;

import com.marko.hiringSystem.entity.Candidate;
import com.marko.hiringSystem.entity.CandidateStatus;
import com.marko.hiringSystem.entity.Resume;
import com.marko.hiringSystem.repository.CandidateRepository;
import com.marko.hiringSystem.repository.ResumeRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final ResumeRepository resumeRepository;

    public CandidateService(CandidateRepository candidateRepository, ResumeRepository resumeRepository) {
        this.candidateRepository = candidateRepository;
        this.resumeRepository = resumeRepository;
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

    public Candidate changeStatus(Long id, CandidateStatus status) {
        Candidate c = this.candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
        c.setStatus(status);
        return candidateRepository.save(c);
    }

    @Transactional
    public void removeById(Long id) {
        Candidate c = candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
        this.resumeRepository.deleteByCandidateId(id);
        this.candidateRepository.delete(c);
    }
}
