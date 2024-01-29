package Lista5.Zadanie1;

import java.util.HashSet;
import java.util.Set;

public class OperacjeNaZbiorach {
    private Set<Integer> zbiorA;
    private Set<Integer> zbiorB;

    public OperacjeNaZbiorach(Set<Integer> zbiorA, Set<Integer> zbiorB) {
        this.zbiorA = new HashSet<>(zbiorA);
        this.zbiorB = new HashSet<>(zbiorB);
    }

    public Set<Integer> suma() {
        Set<Integer> suma = new HashSet<>(zbiorA);
        suma.addAll(zbiorB);
        return suma;
    }

    public Set<Integer> roznica() {
        Set<Integer> roznica = new HashSet<>(zbiorA);
        roznica.removeAll(zbiorB);
        return roznica;
    }

    public Set<Integer> iloczyn() {
        Set<Integer> iloczyn = new HashSet<>(zbiorA);
        iloczyn.retainAll(zbiorB);
        return iloczyn;
    }

    public Set<Integer> roznicaSymetryczna() {
        Set<Integer> roznicaSymetryczna = new HashSet<>(zbiorA);
        roznicaSymetryczna.addAll(zbiorB);
        Set<Integer> wspolne = new HashSet<>(zbiorA);
        wspolne.retainAll(zbiorB);
        roznicaSymetryczna.removeAll(wspolne);
        return roznicaSymetryczna;
    }
    public boolean czyIdentyczne() {
        return zbiorA.equals(zbiorB);
    }

    public boolean czyRozne() {
        return !zbiorA.equals(zbiorB);
    }

    public static void main(String[] args) {
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        setA.add(1);
        setA.add(2);
        setA.add(3);

        setB.add(3);
        setB.add(4);
        setB.add(5);

        OperacjeNaZbiorach operacje = new OperacjeNaZbiorach(setA, setB);

        System.out.println("Suma: " + operacje.suma());
        System.out.println("Różnica: " + operacje.roznica());
        System.out.println("Iloczyn: " + operacje.iloczyn());
        System.out.println("Różnica symetryczna: " + operacje.roznicaSymetryczna());

        System.out.println("Czy identyczne: " + operacje.czyIdentyczne());
        System.out.println("Czy różne: " + operacje.czyRozne());
    }
}
