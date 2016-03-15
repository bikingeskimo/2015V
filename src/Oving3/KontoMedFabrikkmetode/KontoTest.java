package Oving3.KontoMedFabrikkmetode;

//
// Leksjon 2, katalog KontoMedFabrikkmetode
// KontoTest.java E.L. 2003-09-03
//
class KontoTest {
  public static void main(String[] args) {
    Konto olesKonto = Kontofabrikk.lagKonto(123456676756L, "Ole Olsen", 2300.50);

    System.out.println("F�r endring av dataene: \nKontonr: " + olesKonto.finnKontonr() +
      ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());

    olesKonto.gj�rTransaksjon(1000);  // n� er saldo lik 3350,50
    olesKonto.gj�rTransaksjon(-500);  // n� er saldo lik 1850

    System.out.println("Etter endring av dataene: \nKontonr: " + olesKonto.finnKontonr() +
      ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());
  }
}
/* Kj�ring av programmet:
F�r endring av dataene:
Kontonr: 123456676756, navn: Ole Olsen, saldo: 2300.5
Etter endring av dataene:
Kontonr: 123456676756, navn: Ole Olsen, saldo: 2800.5
*/
