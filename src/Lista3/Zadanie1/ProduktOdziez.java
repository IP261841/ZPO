package Lista3.Zadanie1;

// Klasa ProduktOdziez implementująca interfejs Produkt
class ProduktOdziez implements Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;
    private String rozmiar;

    public ProduktOdziez(String nazwa, double cena, int ilosc, String rozmiar) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
        this.rozmiar = rozmiar;
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

    // Metoda specyficzna dla klasy ProduktOdziez
    public void zmienRozmiar(String nowyRozmiar) {
        System.out.println("Rozmiar zmieniony na: " + nowyRozmiar);
    }
}