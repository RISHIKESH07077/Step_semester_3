package string.assignment_problems.Week_7;

public class The_Locker_Code {

    static class Locker {
        private String code;
        private final int lockerNumber;

        public Locker(int lockerNumber, String code) {
            this.lockerNumber = lockerNumber;
            this.code = code;
        }

        public boolean changeCode(String currentCode, String newCode) {
            if (code.equals(currentCode)) {
                code = newCode;
                return true;
            }

            return false;
        }

        public int getLockerNumber() {
            return lockerNumber;
        }
    }

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        System.out.println(
            "First change: " + locker.changeCode("1234", "5678")
        );

        System.out.println(
            "Second change: " + locker.changeCode("0000", "9999")
        );
    }
}
