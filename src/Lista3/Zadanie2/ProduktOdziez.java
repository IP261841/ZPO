package Lista3.Zadanie2;

// Klasa dziedzicząca po klasie abstrakcyjnej ProduktOdziez
class ProduktOdziez extends Produkt {
    private String rozmiar;

    public ProduktOdziez(String nazwa, double cena, int ilosc, String rozmiar) {
        super(nazwa, cena, ilosc);
        this.rozmiar = rozmiar;
    }

    @Override
    public void dodatkowaMetoda() {
        System.out.println("Dodatkowa metoda dla ProduktOdziez");
    }
}