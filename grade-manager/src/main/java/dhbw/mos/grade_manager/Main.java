package dhbw.mos.grade_manager;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GradeManager gradeManager = new GradeManager();
        Module programming = new Module("TINFO24Prog", "Programming", 5.0f);
        Module web2 = new Module("TINFO24Web2", "Web Engineering 2", 5.0f);
        gradeManager.addGrade(Season.WINTER.ofYear(2024), new Grade(programming, 1.3f));
        gradeManager.addGrade(Season.WINTER.ofYear(2024), new Grade(web2, 1.5f));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--- GRADE MANAGER ---");
            System.out.println("1. Add grade");
            System.out.println("2. Print grades");
            System.out.print("Select action: ");
            String action = scanner.nextLine();
            switch (action) {
                case "1":
                    System.out.println("--- ADD GRADE ---");
                    System.out.print("Enter year: ");
                    int year = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter season (WINTER/SUMMER): ");
                    Season season = Season.valueOf(scanner.nextLine());
                    SemesterIdentifier semesterIdentifier = season.ofYear(year);

                    System.out.println("1. Select module");
                    System.out.println("2. Add new module");
                    System.out.print("Select action: ");
                    String moduleAction = scanner.nextLine();

                    Module selectedModule = null;
                    switch (moduleAction) {
                        case "1":
                            List<Module> modules = gradeManager.getModules().stream().toList();
                            for (int i = 1; i <= modules.size(); i++) {
                                Module module = modules.get(i - 1);
                                System.out.printf("%d. %s %s\n", i, module.identifier(), module.name());
                            }
                            System.out.print("Enter module index: ");
                            int moduleIndex = Integer.parseInt(scanner.nextLine()) - 1;
                            selectedModule = modules.get(moduleIndex);
                            break;
                        case "2":
                            System.out.print("Enter module identifier: ");
                            String moduleIdentifier = scanner.nextLine();
                            System.out.print("Enter module name: ");
                            String moduleName = scanner.nextLine();
                            System.out.print("Enter module credits: ");
                            float moduleCredits = Float.parseFloat(scanner.nextLine());

                            selectedModule = new Module(moduleIdentifier, moduleName, moduleCredits);
                            break;
                        default:
                            System.out.println("Invalid action");
                    }
                    if (selectedModule == null) break;

                    System.out.print("Enter grade score: ");
                    float gradeScore = Float.parseFloat(scanner.nextLine());

                    gradeManager.addGrade(semesterIdentifier, new Grade(selectedModule, gradeScore));
                    break;
                case "2":
                    gradeManager.printGrades();
                    break;
                default:
                    System.out.println("Invalid action selected");
            }
        }
    }
}