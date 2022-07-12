package view.tm;

public class CourseTM {
    private String courseId;
    private String courseName;
    private Double cost;
    private String duration;
    private String subjectId;

    public CourseTM() {
    }

    public CourseTM(String courseId, String courseName, Double cost, String duration, String subjectId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.cost = cost;
        this.duration = duration;
        this.subjectId = subjectId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "CourseTM{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", cost=" + cost +
                ", duration='" + duration + '\'' +
                ", subjectId='" + subjectId + '\'' +
                '}';
    }
}
