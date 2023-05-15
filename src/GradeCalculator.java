import  java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class GradeCalculator {
    private List<Integer> avarageGrade;

    public GradeCalculator(){
        avarageGrade = new ArrayList<>();
    }
    public void addGrade(int grade){
        avarageGrade.add(grade);
    }
    public double checkAverageGrade(){
        int sum = 0;
        for (int grade : avarageGrade){
            sum  += grade;
        }
        return (double) sum/avarageGrade.size();
    }
    public static  void main(String[] args){
        System.out.println("Welcome  to the student grade Calculator");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Student: ");
        int input = scanner.nextInt();
        GradeCalculator calculator = new GradeCalculator();

        for(int i = 1; i <= input; i++){
            System.out.println("Enter the grade for student " + i + ": ");
            int grade = scanner.nextInt();
            calculator.addGrade(grade);
        }
        double student = calculator.checkAverageGrade();
        System.out.println("Average Grade: " + student);
        System.out.println(calculator.avarageGrade);
        scanner.close();
    }
}
