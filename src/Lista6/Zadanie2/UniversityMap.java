package Lista6.Zadanie2;

import java.util.HashMap;
import java.util.Map;

public class UniversityMap {
    private Map<String, Subject> subjectsMap;

    public UniversityMap() {
        subjectsMap = new HashMap<>();
    }

    public void addSubject(String subjectName, int ectsPoints, int hours, int semester,
                           LectureType lectureType, AssessmentType assessmentType) {
        Subject subject = new Subject(ectsPoints, hours, semester, lectureType, assessmentType);
        subjectsMap.put(subjectName, subject);
    }

    public void removeSubject(String subjectName) {
        subjectsMap.remove(subjectName);
    }

    public Subject getSubject(String subjectName) {
        return subjectsMap.get(subjectName);
    }

    public void printSubjectInfo(String subjectName) {
        Subject subject = subjectsMap.get(subjectName);
        if (subject != null) {
            System.out.println(subjectName + ": ECTS - " + subject.getEctsPoints() +
                    ", Godziny - " + subject.getHours() +
                    ", Semestr - " + subject.getSemester() +
                    ", Typ zajęć - " + subject.getLectureType() +
                    ", Sposób zaliczenia - " + subject.getAssessmentType());
        } else {
            System.out.println("Przedmiot o nazwie " + subjectName + " nie istnieje.");
        }
    }

    public void printAllSubjects() {
        if (subjectsMap.isEmpty()) {
            System.out.println("Brak przedmiotów w mapie.");
        } else {
            System.out.println("Lista przedmiotów:");
            for (Map.Entry<String, Subject> entry : subjectsMap.entrySet()) {
                String subjectName = entry.getKey();
                Subject subject = entry.getValue();
                System.out.println(subjectName + ": ECTS - " + subject.getEctsPoints() +
                        ", Godziny - " + subject.getHours() +
                        ", Semestr - " + subject.getSemester() +
                        ", Typ zajęć - " + subject.getLectureType() +
                        ", Sposób zaliczenia - " + subject.getAssessmentType());
            }
        }
    }

    public static void main(String[] args) {
        UniversityMap universityMap = new UniversityMap();

        universityMap.addSubject("Matematyka", 6, 60, 1, LectureType.LECTURE, AssessmentType.EXAM);
        universityMap.addSubject("Informatyka", 5, 45, 2, LectureType.EXERCISES, AssessmentType.CREDIT);
        universityMap.addSubject("Fizyka", 4, 30, 1, LectureType.LAB, AssessmentType.EXAM);

        universityMap.printAllSubjects();

        universityMap.removeSubject("Informatyka");
        universityMap.printAllSubjects();

        universityMap.printSubjectInfo("Matematyka");
        universityMap.printSubjectInfo("Informatyka");
    }
}
