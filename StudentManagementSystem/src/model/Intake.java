package model;

import java.time.LocalDate;

public class Intake {
    private String intakeId;
    private LocalDate startDate;
    private String description;
    private String courseId;

    public Intake() {
    }

    public Intake(String intakeId, LocalDate startDate, String description, String courseId) {
        this.intakeId = intakeId;
        this.startDate = startDate;
        this.description = description;
        this.courseId = courseId;
    }

    public String getIntakeId() {
        return intakeId;
    }

    public void setIntakeId(String intakeId) {
        this.intakeId = intakeId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Intake{" +
                "intakeId='" + intakeId + '\'' +
                ", startDate=" + startDate +
                ", description='" + description + '\'' +
                ", courseId='" + courseId + '\'' +
                '}';
    }
}
