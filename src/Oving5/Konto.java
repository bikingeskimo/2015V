package Oving5;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;


/**
 * Created by Roger on 30/03/2016.
 */

@Entity
public class Konto implements Serializable{
    @Id
    private String kontonr;
    private double saldo;
    private String eier;

    @Version
    private int laasing;


    public Konto(){}

    public Konto(String kontonr, double saldo, String eier, int lfelt) {
        this.kontonr = kontonr;
        this.saldo = saldo;
        this.eier = eier;
        laasing = lfelt;
    }

    public String getKontonr() {
        return kontonr;
    }

    public void setKontonr(String kontonr) {
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

    public int getLaasing() {
        return laasing;
    }

    public void setLaasing(int laasing) {
        this.laasing = laasing;
    }

    public synchronized void trekkBelop(double belop) throws IkkeDekningException{
        if ((saldo - belop) < 0){
            throw new IkkeDekningException("Ikke dekning på kontoen");
        }else {
            saldo -= belop;
        }
    }

    public void motta(double belop){saldo += belop;}

    @Override
    public String toString() {
        return "Konto{" +
                "laasing=" + laasing +
                ", kontonr=" + kontonr +
                ", saldo=" + saldo +
                ", eier='" + eier + '\'' +
                '}';
    }
}
