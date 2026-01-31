package com.marko.hiringSystem.service;

import com.marko.hiringSystem.entity.Candidate;
import com.marko.hiringSystem.entity.Resume;
import com.marko.hiringSystem.repository.CandidateRepository;
import com.marko.hiringSystem.repository.ResumeRepository;
import org.springframework.stereotype.Service;

@Service
public class ResumeService {
    private final ResumeRepository resumeRepository;
    private final CandidateRepository candidateRepository;

    public ResumeService(ResumeRepository resumeRepository, CandidateRepository candidateRepository) {
        this.resumeRepository = resumeRepository;
        this.candidateRepository = candidateRepository;
    }

    public Resume createResumeForCandidate(Resume resume, Long candidateId) {
        Candidate c = candidateRepository.findById(candidateId).orElseThrow(() -> new RuntimeException("Candidate not found"));
        resume.setCandidate(c);
        return this.resumeRepository.save(resume);
    }
}
