package Lista8.Zadanie3.Wersja1;

class SharedBank {
    private int balance = 1000; // Początkowy stan konta

    public void withdraw(int amount) {
        int currentBalance = balance;
        if (amount <= currentBalance) {
            // Symulacja czasochłonnej operacji
            try {
                Thread.sleep(10); // ms
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " New balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }
}
