package com.example.module_javaspringboot_day9_02.dto;

public class ScoreDTO {
    private Long id;
    private int processScore;
    private int testScore;
    private int finalScore;
    private StudentDTO studentDTO;
    private SubjectDTO subjectDTO;


    public ScoreDTO() {
    }

    public ScoreDTO(Long id, int processScore, int testScore, int finalScore, StudentDTO studentDTO, SubjectDTO subjectDTO) {
        this.id = id;
        this.processScore = processScore;
        this.testScore = testScore;
        this.finalScore = finalScore;
        this.studentDTO = studentDTO;
        this.subjectDTO = subjectDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getProcessScore() {
        return processScore;
    }

    public void setProcessScore(int processScore) {
        this.processScore = processScore;
    }

    public int getTestScore() {
        return testScore;
    }

    public void setTestScore(int testScore) {
        this.testScore = testScore;
    }

    public int getFinalScore() {
        return finalScore;
    }

    public void setFinalScore(int finalScore) {
        this.finalScore = finalScore;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public SubjectDTO getSubjectDTO() {
        return subjectDTO;
    }

    public void setSubjectDTO(SubjectDTO subjectDTO) {
        this.subjectDTO = subjectDTO;
    }
}
