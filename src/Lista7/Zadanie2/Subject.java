package Lista7.Zadanie2;

enum LectureType {
    LECTURE,
    EXERCISES,
    LAB
}

enum AssessmentType {
    EXAM,
    CREDIT
}

class Subject {
    private int ectsPoints;
    private int hours;
    private int semester;
    private LectureType lectureType;
    private AssessmentType assessmentType;

    public Subject() {
        // Default constructor for Jackson JSON deserialization
    }

    public Subject(int ectsPoints, int hours, int semester, LectureType lectureType, AssessmentType assessmentType) {
        this.ectsPoints = ectsPoints;
        this.hours = hours;
        this.semester = semester;
        this.lectureType = lectureType;
        this.assessmentType = assessmentType;
    }

    // Getters and setters

    public int getEctsPoints() {
        return ectsPoints;
    }

    public void setEctsPoints(int ectsPoints) {
        this.ectsPoints = ectsPoints;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public LectureType getLectureType() {
        return lectureType;
    }

    public void setLectureType(LectureType lectureType) {
        this.lectureType = lectureType;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }

    public void setAssessmentType(AssessmentType assessmentType) {
        this.assessmentType = assessmentType;
    }
}