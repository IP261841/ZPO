package Lista5.Zadanie3;

class Subject {
    private int ectsPoints;
    private int hours;
    private int semester;

    public Subject(int ectsPoints, int hours, int semester) {
        this.ectsPoints = ectsPoints;
        this.hours = hours;
        this.semester = semester;
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
}