package Lista5.Zadanie2;

// Klasa abstrakcyjna Produkt
abstract class Produkt {
    private String nazwa;
    private double cena;
    private int ilosc;

    public Produkt(String nazwa, double cena, int ilosc) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.ilosc = ilosc;
    }

    public String pobierzNazwe() {
        return nazwa;
    }

    public double pobierzCene() {
        return cena;
    }

    public int pobierzIlosc() {
        return ilosc;
    }

    // Metoda abstrakcyjna do implementacji w klasach pochodnych
    public abstract void dodatkowaMetoda();
}