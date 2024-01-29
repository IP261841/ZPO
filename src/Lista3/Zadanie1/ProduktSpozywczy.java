package Lista3.Zadanie1;

// Klasa ProduktSpozywczy implementująca interfejs Produkt
class ProduktSpozywczy implements Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;

    public ProduktSpozywczy(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
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

    // Metoda specyficzna dla klasy ProduktSpozywczy
    public void ustawTerminWaznosci(String terminWaznosci) {
        System.out.println("Termin ważności ustawiony na: " + terminWaznosci);
    }
}