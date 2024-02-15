package Lista8.Zadanie3.Wersja1;

class WithdrawThread implements Runnable {
    private final SharedBank bank;
    private final int amount;

    public WithdrawThread(SharedBank bank, int amount) {
        this.bank = bank;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.withdraw(amount);
    }
}
