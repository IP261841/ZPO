package Lista5.Zadanie4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StatystykaZdania {

    private String zdanie;
    private Set<String> slowa;
    private Map<String, Integer> liczbaWystapien;

    public StatystykaZdania(String zdanie) {
        this.zdanie = zdanie;
        this.slowa = new HashSet<>();
        this.liczbaWystapien = new HashMap<>();
        analizujZdanie();
    }

    private void analizujZdanie() {
        // Dzielimy zdanie na słowa
        String[] slowaArray = zdanie.split("\\s+");

        // Liczymy liczbę słów i dodajemy do zbioru
        int liczbaSlow = 0;
        for (String slowo : slowaArray) {
            if (!slowo.isEmpty()) {
                liczbaSlow++;
                slowa.add(slowo);

                // Zliczamy wystąpienia słów
                liczbaWystapien.put(slowo, liczbaWystapien.getOrDefault(slowo, 0) + 1);
            }
        }

        // Dodajemy liczbę słów do zbioru
        slowa.add("Całkowita liczba słów");
        liczbaWystapien.put("Całkowita liczba słów", liczbaSlow);

        // Dodajemy liczbę znaków do zbioru
        slowa.add("Całkowita liczba znaków");
        liczbaWystapien.put("Całkowita liczba znaków", zdanie.length());
    }

    public void wyswietlStatystyke() {
        System.out.println("Statystyka zdania:");

        for (String slowo : slowa) {
            System.out.println(slowo + ": " + liczbaWystapien.get(slowo));
        }
    }

    public static void main(String[] args) {
        // Przykładowe użycie
        String zdanie = "To jest przykładowe zdanie. To zdanie ma kilka słów. Kilka.";
        StatystykaZdania statystyka = new StatystykaZdania(zdanie);
        statystyka.wyswietlStatystyke();
    }
}
