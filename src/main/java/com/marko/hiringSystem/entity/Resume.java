package com.marko.hiringSystem.entity;

import jakarta.persistence.*;

@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String experiences;
    private String hobbies;
    private String education;

    @OneToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    public Resume() {

    }

    public Resume(String experiences, String hobbies, String education) {
        this.experiences = experiences;
        this.hobbies = hobbies;
        this.education = education;
    }

    public String getExperiences() {
        return experiences;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getEducation() {
        return education;
    }

    public Long getId() {
        return id;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
