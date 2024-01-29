package Lista5.Zadanie2;

// Przykładowe użycie
public class Main {
    public static void main(String[] args) {
        Magazyn magazyn = new Magazyn();

        // Tworzenie obiektów różnych klas dziedziczących po klasie abstrakcyjnej Produkt
        ProduktSpozywczy produktSpozywczy = new ProduktSpozywczy("Chleb", 2.5, 10);
        ProduktElektroniczny produktElektroniczny = new ProduktElektroniczny("Telefon", 1200.0, 5, "Samsung");
        ProduktOdziez produktOdziez = new ProduktOdziez("Koszulka", 30.0, 20, "M");

        // Dodawanie produktów do magazynu z unikalnymi kluczami
        magazyn.dodajProdukt("chleb123", produktSpozywczy);
        magazyn.dodajProdukt("telefon456", produktElektroniczny);
        magazyn.dodajProdukt("koszulka789", produktOdziez);

        // Wyświetlanie stanu magazynu
        magazyn.wyswietlStanMagazynu();
    }
}