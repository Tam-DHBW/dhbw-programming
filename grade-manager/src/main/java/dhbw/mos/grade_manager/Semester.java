package dhbw.mos.grade_manager;

import java.util.ArrayList;
import java.util.List;

public class Semester {
    public List<Grade> grades = new ArrayList<>();

    public void addGrade(Grade grade) {
        grades.add(grade);
    }

    public float gpa() {
        // Loop through all grades
        //      Add grade credits to sumCredits
        //      Add score * credits to sumScore
        // return sumScore / sumCredits
        float sumCredits = 0;
        float sumScore = 0;

        for (Grade grade : grades) {
            float credits = grade.module().credits();
            float score = grade.score();
            sumCredits += credits;
            sumScore += score * credits;
        }

        if (sumCredits == 0) {
            return 0; // avoid division by zero
        }

        return sumScore / sumCredits;
    }
}



