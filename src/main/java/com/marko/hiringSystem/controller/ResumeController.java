package com.marko.hiringSystem.controller;

import com.marko.hiringSystem.entity.Resume;
import com.marko.hiringSystem.service.ResumeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates/{candidateId}/resume")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @PostMapping
    public Resume createResume(
        @PathVariable Long candidateId,
        @RequestBody Resume resume
    ) {
        return resumeService.createResumeForCandidate(resume, candidateId);
    }
}