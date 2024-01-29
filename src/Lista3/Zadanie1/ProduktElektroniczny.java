package Lista3.Zadanie1;

// Klasa ProduktElektroniczny implementująca interfejs Produkt
class ProduktElektroniczny implements Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;
    private String producent;

    public ProduktElektroniczny(String nazwa, double cena, int ilosc, String producent) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.producent = producent;
    }

    @Override
    public String pobierzNazwe() {
        return nazwa;
    }

    @Override
    public double pobierzCene() {
        return cena;
    }

    @Override
    public int pobierzIlosc() {
        return ilosc;
    }

    // Metoda specyficzna dla klasy ProduktElektroniczny
    public void sprawdzGwarancje() {
        System.out.println("Gwarancja od producenta ważna.");
    }
}