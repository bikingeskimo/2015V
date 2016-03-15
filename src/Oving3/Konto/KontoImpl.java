package Oving3.Konto;

//
// Leksjon 2, katalog Konto
// KontoImpl.java E.L. 2003-09-04
//
class KontoImpl implements Konto {
  private long   kontonr;
  private String navn;
  private double saldo;

  public KontoImpl(long startKontonr, String startNavn, double startSaldo) {
    kontonr = startKontonr;
    navn = startNavn;
    saldo = startSaldo;
  }

  public long finnKontonr() {
    return kontonr;
  }

  public String finnNavn() {
    return navn;
  }

  public double finnSaldo() {
    return saldo;
  }

  public void gj�rTransaksjon(double bel�p) {
    saldo += bel�p;
  }
}

