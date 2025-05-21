package dhbw.mos.grade_manager;

import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;

public class GradeManager {
    HashMap<SemesterIdentifier, Semester> semesters = new HashMap<>();

    public void addGrade(SemesterIdentifier semesterId, Grade grade) {
        Semester semester = semesters
                .getOrDefault(semesterId, new Semester());
        semester.addGrade(grade);
        semesters.put(semesterId, semester);
    }

    public Set<Module> getModules() {
        return semesters
                .values()
                .stream()
                .flatMap(semester -> semester.grades.stream())
                .map(Grade::module)
                .collect(Collectors.toSet());
    }

    public void printGrades(SemesterIdentifier semesterId) {
        Semester semester = semesters.getOrDefault(semesterId, new Semester());

        StringBuilder output = new StringBuilder();
        String header =
                "%s %s SEMESTER OF YEAR %d --- GPA %.1f %s".formatted(
                        "-".repeat(3),
                        semesterId.season().toString(),
                        semesterId.year(),
                        semester.gpa(),
                        "-".repeat(45)
                );

        output.append(header).append("\n");
        appendEntry(output, "Nr.", "Module", "Grade", "Credits", "Status").append("\n");

        for (Grade grade : semester.grades) {
            appendEntry(
                    output,
                    grade.module().identifier(),
                    grade.module().name(),
                    Float.toString(grade.score()),
                    Float.toString(grade.module().credits()),
                    grade.passed() ? "Passed" : "Failed"
            ).append("\n");

        }

        output.append("-".repeat(header.length())).append("\n");

        System.out.print(output.toString());
    }

    public void printGrades() {
        for (SemesterIdentifier semesterIdentifier : semesters.keySet()) {
            printGrades(semesterIdentifier);
        }
    }

    private StringBuilder appendEntry(
            StringBuilder builder,
            String moduleIdentifier,
            String moduleName,
            String score,
            String credits,
            String passed
    ) {
        return builder.append("%-15s %-30s %-10s %-10s %-10s".formatted(
                moduleIdentifier,
                moduleName,
                score,
                credits,
                passed
        ));
    }
}
