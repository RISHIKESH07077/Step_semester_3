package string.assignment_problems.Week_7;

public class The_Quiz_Scorecard {

    static class Scorecard {
        private final boolean[] results;
        private int answersRecorded;

        public Scorecard(int questionCount) {
            results = new boolean[Math.max(0, questionCount)];
            answersRecorded = 0;
        }

        public boolean recordAnswer(boolean correct) {
            if (answersRecorded >= results.length) {
                return false;
            }

            results[answersRecorded] = correct;
            answersRecorded++;
            return true;
        }

        public int getScore() {
            int score = 0;

            for (int i = 0; i < answersRecorded; i++) {
                if (results[i]) {
                    score++;
                }
            }

            return score;
        }
    }

    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);

        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore());
    }
}