package string.assignment_problems.week8_assignment;

import java.time.LocalDate;
import java.util.Scanner;

public class The_Streaming_Plan_Renewal_Reminder {

    interface SubscriptionPlan {
        int getValidityDays();
    }

    static class BasicPlan implements SubscriptionPlan {
        public int getValidityDays() {
            return 30;
        }
    }

    static class StandardPlan implements SubscriptionPlan {
        public int getValidityDays() {
            return 90;
        }
    }

    static class PremiumPlan implements SubscriptionPlan {
        public int getValidityDays() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            SubscriptionPlan plan;

            switch (type) {
                case "BASIC":
                    plan = new BasicPlan();
                    break;
                case "STANDARD":
                    plan = new StandardPlan();
                    break;
                case "PREMIUM":
                    plan = new PremiumPlan();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid plan type");
            }

            LocalDate renewalDate =
                    startDate.plusDays(plan.getValidityDays());

            System.out.println(name + ": " + renewalDate);
        }

        sc.close();
    }
}