package Lista8.Zadanie1;

public class MultiThreadPrinting implements Runnable {
    private final int threadId;

    public MultiThreadPrinting(int id) {
        this.threadId = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Thread " + threadId + ": " + i);
            try {
                // Symulacja pracy wątku
                Thread.sleep(100); // Można zmienić czas w milisekundach
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final int NUM_THREADS = 5; // Liczba wątków do utworzenia

        // Tworzenie i uruchamianie wątków
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(new MultiThreadPrinting(i + 1));
            thread.start();
        }
    }
}
