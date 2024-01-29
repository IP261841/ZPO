package Lista3.Zadanie2;

// Klasa dziedzicząca po klasie abstrakcyjnej ProduktElektroniczny
class ProduktElektroniczny extends Produkt {
    private String producent;

    public ProduktElektroniczny(String nazwa, double cena, int ilosc, String producent) {
        super(nazwa, cena, ilosc);
        this.producent = producent;
    }

    @Override
    public void dodatkowaMetoda() {
        System.out.println("Dodatkowa metoda dla ProduktElektroniczny");
    }
}