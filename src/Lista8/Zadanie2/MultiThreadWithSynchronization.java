package Lista8.Zadanie2;

public class MultiThreadWithSynchronization implements Runnable {
    private static int counter = 0;
    private final int threadId;
    private static final Object lock = new Object();

    public MultiThreadWithSynchronization(int id) {
        this.threadId = id;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (lock) {
                counter++;
                System.out.println("Thread " + threadId + " - Counter: " + counter);
            }
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
            Thread thread = new Thread(new MultiThreadWithSynchronization(i + 1));
            thread.start();
        }
    }
}