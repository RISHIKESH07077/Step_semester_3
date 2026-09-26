package string.assignment_problems;

public class Applicant_Object_Counter {

    static class Applicant {

        static int totalApplicants;

        public Applicant() {
            totalApplicants++;
        }
    }

    public static void main(String[] args) {

        Applicant applicant1 = new Applicant();
        Applicant applicant2 = new Applicant();
        Applicant applicant3 = new Applicant();

        System.out.println("Total applicants: " + Applicant.totalApplicants);
    }
}