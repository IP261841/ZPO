package Lista7.Zadanie2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

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

    public int getTotalHoursByLectureType(LectureType lectureType) {
        return subjectsMap.values().stream()
                .filter(subject -> subject.getLectureType() == lectureType)
                .mapToInt(Subject::getHours)
                .sum();
    }

    public Map<String, Integer> getExamSubjectsSummary() {
        return subjectsMap.entrySet().stream()
                .filter(entry -> entry.getValue().getAssessmentType() == AssessmentType.EXAM)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().getHours(),
                        (e1, e2) -> e1,
                        HashMap::new
                ));
    }

    public void exportToJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(filePath), subjectsMap);
    }

    public void importFromJson(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        subjectsMap = objectMapper.readValue(new File(filePath), new TypeReference<HashMap<String, Subject>>() {});
    }

    public static void main(String[] args) throws IOException {
        UniversityMap universityMap = new UniversityMap();

        universityMap.addSubject("Matematyka", 6, 60, 1, LectureType.LECTURE, AssessmentType.EXAM);
        universityMap.addSubject("Informatyka", 5, 45, 2, LectureType.EXERCISES, AssessmentType.CREDIT);
        universityMap.addSubject("Fizyka", 4, 30, 1, LectureType.LAB, AssessmentType.EXAM);

        // Export to JSON
        universityMap.exportToJson("src/Lista7/Zadanie2/subjects.json");

        // Clear the map to simulate importing
        universityMap.subjectsMap.clear();

        // Import from JSON
        universityMap.importFromJson("src/Lista7/Zadanie2/subjects.json");

        // Print imported subjects
        universityMap.printAllSubjects();
    }
}