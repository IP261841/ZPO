package Lista8.Zadanie3.Wersja1;

public class SharedBankDemo {
    public static void main(String[] args) {
        SharedBank bank = new SharedBank();

        // Tworzenie i uruchamianie wątków
        Thread thread1 = new Thread(new WithdrawThread(bank, 500));
        Thread thread2 = new Thread(new WithdrawThread(bank, 700));

        thread1.start();
        thread2.start();
    }
}