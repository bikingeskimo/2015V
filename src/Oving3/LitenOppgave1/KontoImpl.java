package Oving3.LitenOppgave1;

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

  public String toString() {
    return "Kontonr.: " + kontonr + ", navn: " + navn + ", saldo: " + saldo;
  }

  public boolean sammeNavn(KontoImpl konto2) { // ikke med i interfacet
    return navn.equalsIgnoreCase(konto2.navn);
  }
}

