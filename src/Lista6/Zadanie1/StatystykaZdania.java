package Lista6.Zadanie1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
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
        final long[] liczbaSlow = {0};
        for (String slowo : slowaArray) {
            Optional<String> optionalSlowo = Optional.of(slowo).filter(s -> !s.isEmpty());
            optionalSlowo.ifPresent(s -> {
                liczbaSlow[0]++;
                slowa.add(s);

                // Zliczamy wystąpienia słów
                liczbaWystapien.put(s, liczbaWystapien.getOrDefault(s, 0) + 1);
            });
        }

        // Dodajemy liczbę słów do zbioru
        Optional<String> optionalLiczbaSlow = Optional.of("Całkowita liczba słów");
        optionalLiczbaSlow.ifPresent(s -> liczbaWystapien.put(s, (int) liczbaSlow[0]));

        // Dodajemy liczbę znaków do zbioru
        Optional<String> optionalLiczbaZnakow = Optional.of("Całkowita liczba znaków");
        optionalLiczbaZnakow.ifPresent(s -> liczbaWystapien.put(s, zdanie.length()));
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
