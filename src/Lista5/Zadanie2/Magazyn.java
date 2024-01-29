package Lista5.Zadanie2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Klasa Magazyn przechowująca produkty w mapie
class Magazyn {
    private Map<String, Produkt> mapaProduktow;

    public Magazyn() {
        this.mapaProduktow = new HashMap<>();
    }

    // Metoda do dodawania produktów do mapy
    public void dodajProdukt(String klucz, Produkt produkt) {
        mapaProduktow.put(klucz, produkt);
    }

    // Metoda do wyświetlania stanu magazynu
    public void wyswietlStanMagazynu() {
        System.out.println("Stan magazynu:");
        for (Map.Entry<String, Produkt> entry : mapaProduktow.entrySet()) {
            String klucz = entry.getKey();
            Produkt produkt = entry.getValue();
            System.out.println("Klucz: " + klucz +
                    ", Nazwa: " + produkt.pobierzNazwe() +
                    ", Cena: " + produkt.pobierzCene() +
                    ", Ilość: " + produkt.pobierzIlosc());
            produkt.dodatkowaMetoda(); // Wywołanie dodatkowej metody dla każdego produktu
        }
    }
}