import java.util.Scanner;
import java.lang.Math;

class Grades {

    public static Scanner input = new Scanner(System.in);

    public static double getGradesAvg(String assignmentType, int entries, Boolean isInt) {
        System.out.printf("Enter the %s grades for this class (%d entries):\n", assignmentType, entries);

        double sum = 0;
        //Take entries
        for(int i = 0; i < entries; i++) {

            System.out.print(
                String.format("Entry #%x: ", i + 1)
            );

            if(isInt) {
                sum += input.nextInt();
            } else {
                sum += input.nextDouble();
            }
        }

        double avg = sum / entries;

        return avg;
    }

    public static void main(String[] args) {

        //Ask user for class name
        System.out.print("Enter the course name: ");
        String courseName = input.nextLine();

        //Ask how much time the course takes
        System.out.print("Enter the average amount of time spent per week for this course in minutes: ");
        int courseTime = input.nextInt();

        double hwAvg = getGradesAvg("homework", 4, true);

        double quizAvg = getGradesAvg("quiz", 2, false);

        //Ask for final exam grade
        System.out.print("Enter the final exam grade for the course: ");
        double finalExamGrade = input.nextDouble();

        //Print out statistics
        System.out.printf("Course name: %s\n", courseName);
        //Course time hours and minutes
        int hours = courseTime / 60;
        int minutes = courseTime % 60;
        System.out.printf("Weekly time spent: %dh%d\n", hours, minutes);

        System.out.printf("Average homework grade: %.2f\n", hwAvg);
        System.out.printf("Average quiz grade: %.2f\n", quizAvg);
        System.out.printf("Final exam grade: %.2f\n", finalExamGrade);

        long overallGrade = Math.round(hwAvg * 0.35 + quizAvg * 0.15 + finalExamGrade * 0.5);
        System.out.printf("Overall grade: %d\n", overallGrade);

        input.close();
    }

}