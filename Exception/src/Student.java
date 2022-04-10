import java.util.Scanner;
//........
public class Student {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("firstname:");
        String firstname = s.nextLine();
        System.out.println("lastname:");
        String lastname = s.nextLine();
        System.out.println("national code:");
        String nationalCode = s.nextLine();
        System.out.println("number of lessons:");
        int n = s.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            grades[i] = s.nextInt();
        }
        String result = "";
        try {
            checkValidation(firstname, lastname, nationalCode);
            checkGrades(grades);
            result = "information saved";
        } catch (GradeValidationException | InformationValidationException e) {
            System.err.println(e.getMessage());
            result = "information didn't saved";
        } finally {
            System.out.println(result);
            System.out.println("test");
        }
    }

    public static void checkValidation(String firstname, String lastname, String nationalCode) throws InformationValidationException {
        for (int i = 0; i <= 9; i++) {

            if (firstname.contains(String.valueOf(i)) || lastname.contains(String.valueOf(i))) {
                throw new InformationValidationException("Error in saving name");
            }
        }

    }

    public static void checkGrades(int[] grades) throws GradeValidationException {
        for (int grade : grades) {
            if (grade < 0) {
                throw new GradeValidationException("grades can't be negative");
            }
        }
    }
}

class InformationValidationException extends Exception {
    public InformationValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

class GradeValidationException extends Exception {
    public GradeValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}

