package Oving3.LitenOppgave1;

interface Konto {
  long finnKontonr();
  String finnNavn();
  double finnSaldo();
  void gjørTransaksjon(double beløp);
  String toString();
}

