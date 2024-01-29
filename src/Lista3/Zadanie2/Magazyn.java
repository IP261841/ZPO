package Lista3.Zadanie2;

import java.util.ArrayList;
import java.util.List;

// Klasa Magazyn przechowująca listę produktów
class Magazyn {
    private List<Produkt> listaProduktow;

    public Magazyn() {
        this.listaProduktow = new ArrayList<>();
    }

    // Metoda do dodawania produktów różnych klas do listy
    public void dodajProdukt(Produkt produkt) {
        listaProduktow.add(produkt);
    }

    // Metoda do wyświetlania stanu magazynu
    public void wyswietlStanMagazynu() {
        System.out.println("Stan magazynu:");
        for (Produkt produkt : listaProduktow) {
            System.out.println("Nazwa: " + produkt.pobierzNazwe() +
                    ", Cena: " + produkt.pobierzCene() +
                    ", Ilość: " + produkt.pobierzIlosc());
            produkt.dodatkowaMetoda(); // Wywołanie dodatkowej metody dla każdego produktu
        }
    }
}