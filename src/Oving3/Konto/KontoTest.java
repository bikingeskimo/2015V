package Oving3.Konto;

//
// Leksjon 2, katalog Konto
// KontoTest.java E.L. 2003-09-04
//
class KontoTest {
  public static void main(String[] args) {
    Konto olesKonto = new KontoImpl(123456676756L, "Ole Olsen", 2300.50);

    System.out.println("Før endring av dataene: \nKontonr: " + olesKonto.finnKontonr() +
      ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());

    olesKonto.gjørTransaksjon(1000);  // nï¿½ er saldo lik 3300,50
    olesKonto.gjørTransaksjon(-500);  // nï¿½ er saldo lik 2800,50

    System.out.println("Etter endring av dataene: \nKontonr: " + olesKonto.finnKontonr() +
      ", navn: " + olesKonto.finnNavn() + ", saldo: " + olesKonto.finnSaldo());
  }
}
/* Kjï¿½ring av programmet:
Fï¿½r endring av dataene:
Kontonr: 123456676756, navn: Ole Olsen, saldo: 2300.5
Etter endring av dataene:
Kontonr: 123456676756, navn: Ole Olsen, saldo: 2800.5
*/
