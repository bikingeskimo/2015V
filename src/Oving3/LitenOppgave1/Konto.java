package Oving3.LitenOppgave1;

interface Konto {
  long finnKontonr();
  String finnNavn();
  double finnSaldo();
  void gj�rTransaksjon(double bel�p);
  String toString();
}

