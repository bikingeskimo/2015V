package Oving3.KontoMedFabrikkmetode;

//
// Leksjon 2, katalog KontoMedFabrikkmetode
// Konto.java E.L. 2003-09-03
//
interface Konto {
  long finnKontonr();
  String finnNavn();
  double finnSaldo();
  void gj�rTransaksjon(double bel�p);
}

