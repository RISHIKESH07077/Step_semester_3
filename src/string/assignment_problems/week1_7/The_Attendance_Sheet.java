package string.assignment_problems.Week_7;

public class The_Attendance_Sheet {

    static class AttendanceSheet {
        private final String[] students;
        private int presentCount;

        public AttendanceSheet(int capacity) {
            students = new String[Math.max(0, capacity)];
            presentCount = 0;
        }

        public boolean markPresent(String name) {
            if (name == null || isPresent(name)
                    || presentCount >= students.length) {
                return false;
            }

            students[presentCount] = name;
            presentCount++;
            return true;
        }

        public int getPresentCount() {
            return presentCount;
        }

        public boolean isPresent(String name) {
            if (name == null) {
                return false;
            }

            for (int i = 0; i < presentCount; i++) {
                if (students[i].equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);

        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana");

        System.out.println("Present count: " + sheet.getPresentCount());
        System.out.println("Ben present: " + sheet.isPresent("Ben"));
        System.out.println("Chen present: " + sheet.isPresent("Chen"));
    }
}