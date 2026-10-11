package string.assignment_problems.week8;

import java.util.Scanner;
import java.util.Locale;

public class Examination_Question_Grader {

    interface Question {
        double grade();
        String getType();
    }

    static class MCQ implements Question {
        String correct, answer;
        double points;

        MCQ(String correct, String answer, double points) {
            this.correct = correct;
            this.answer = answer;
            this.points = points;
        }

        public double grade() {
            return answer.equals(correct) ? points : 0;
        }

        public String getType() {
            return "MCQ";
        }
    }

    static class TrueFalse implements Question {
        String correct, answer;
        double points;

        TrueFalse(String correct, String answer, double points) {
            this.correct = correct;
            this.answer = answer;
            this.points = points;
        }

        public double grade() {
            return answer.equals(correct) ? points : 0;
        }

        public String getType() {
            return "TF";
        }
    }

    static class Essay implements Question {
        String keywords, answer;
        double points;

        Essay(String keywords, String answer, double points) {
            this.keywords = keywords;
            this.answer = answer;
            this.points = points;
        }

        public double grade() {
            String lowerAnswer = answer.toLowerCase(Locale.ROOT);
            String[] words = keywords.split(",");
            int matches = 0;

            for (String word : words) {
                String keyword = word.trim().toLowerCase(Locale.ROOT);
                if (!keyword.isEmpty() && lowerAnswer.contains(keyword)) {
                    matches++;
                }
            }

            if (matches >= 2) {
                return points * 0.75;
            } else if (matches == 1) {
                return points * 0.50;
            }

            return 0;
        }

        public String getType() {
            return "ESSAY";
        }
    }

    private static String[] parseQuotedFields(String line) {
        java.util.ArrayList<String> fields = new java.util.ArrayList<>();
        java.util.regex.Matcher matcher =
                java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)")
                        .matcher(line);

        while (matcher.find()) {
            fields.add(matcher.group(1) != null
                    ? matcher.group(1) : matcher.group(2));
        }

        return fields.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = parseQuotedFields(sc.nextLine().trim());
            String type = p[0];

            Question question;

            switch (type) {
                case "MCQ":
                    question = new MCQ(p[2], p[3],
                            Double.parseDouble(p[4]));
                    break;
                case "TF":
                    question = new TrueFalse(p[2], p[3],
                            Double.parseDouble(p[4]));
                    break;
                case "ESSAY":
                    question = new Essay(p[2], p[3],
                            Double.parseDouble(p[4]));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid question type");
            }

            double score = question.grade();
            total += score;

            System.out.printf(Locale.US, "%s: %.2f%n",
                    question.getType(), score);
        }

        System.out.printf(Locale.US, "Total Score: %.2f%n", total);
        sc.close();
    }
}