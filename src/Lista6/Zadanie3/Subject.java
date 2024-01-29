package Lista6.Zadanie3;

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

    public Subject(int ectsPoints, int hours, int semester, LectureType lectureType, AssessmentType assessmentType) {
        this.ectsPoints = ectsPoints;
        this.hours = hours;
        this.semester = semester;
        this.lectureType = lectureType;
        this.assessmentType = assessmentType;
    }

    public int getEctsPoints() {
        return ectsPoints;
    }

    public int getHours() {
        return hours;
    }

    public int getSemester() {
        return semester;
    }

    public LectureType getLectureType() {
        return lectureType;
    }

    public AssessmentType getAssessmentType() {
        return assessmentType;
    }
}