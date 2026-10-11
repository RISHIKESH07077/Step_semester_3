package string.assignment_problems.Week_7;

public class The_Piggy_Bank {

    static class PiggyBank {
        private int savings;
        private final String bankId;

        public PiggyBank(String bankId) {
            this.bankId = bankId;
            this.savings = 0;
        }

        public void deposit(int amount) {
            if (amount > 0) {
                savings += amount;
            }
        }

        public boolean withdraw(int amount) {
            if (amount > 0 && amount <= savings) {
                savings -= amount;
                return true;
            }
            return false;
        }

        public int getSavings() {
            return savings;
        }

        public String getBankId() {
            return bankId;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());

        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());

        boolean result = pb.withdraw(500);
        System.out.println("Withdrawal successful: " + result);
        System.out.println("Savings: " + pb.getSavings());
    }
}