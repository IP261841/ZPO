package Lista5.Zadanie2;

// Klasa dziedzicząca po klasie abstrakcyjnej ProduktSpozywczy
class ProduktSpozywczy extends Produkt {
    public ProduktSpozywczy(String nazwa, double cena, int ilosc) {
        super(nazwa, cena, ilosc);
    }

    @Override
    public void dodatkowaMetoda() {
        System.out.println("Dodatkowa metoda dla ProduktSpozywczy");
    }
}