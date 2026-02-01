package com.marko.hiringSystem.controller;

import com.marko.hiringSystem.entity.Candidate;
import com.marko.hiringSystem.entity.CandidateStatus;
import com.marko.hiringSystem.service.CandidateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public Candidate createCandidate(@RequestBody Candidate candidate) {
        return this.candidateService.createCandidate(candidate);
    }

    @GetMapping
    public List<Candidate> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @GetMapping("/{id}")
    public Candidate getCandidateById(@PathVariable Long id) {
        return this.candidateService.getCandidateById(id);
    }

    @PostMapping("/{id}/status")
    public Candidate changeStatus(@PathVariable Long id, @RequestBody CandidateStatus status) {
        return this.candidateService.changeStatus(id, status);
    }

    @DeleteMapping("/{id}")
    public void deleteCandidate(@PathVariable Long id) {
        candidateService.removeById(id);
    }

}
