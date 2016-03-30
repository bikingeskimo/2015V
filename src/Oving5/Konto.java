package Oving5;

/**
 * Created by Roger on 30/03/2016.
 */
public class Konto {
    private int kontonr;
    private double saldo;
    private String eier;

    public Konto(int kontonr, double saldo, String eier) {
        this.kontonr = kontonr;
        this.saldo = saldo;
        this.eier = eier;
    }

    public int getKontonr() {
        return kontonr;
    }

    public void setKontonr(int kontonr) {
        this.kontonr = kontonr;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getEier() {
        return eier;
    }

    public void setEier(String eier) {
        this.eier = eier;
    }

    public void trekk(double belop){
        if (belop > saldo){
            System.out.println("IkkeDekningException");
        }
    }
}
