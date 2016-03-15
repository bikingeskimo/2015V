package Oving3.LitenOppgave2;

import static javax.swing.JOptionPane.*;
import java.rmi.*;
class KontoKlient {
  public static void main(String[] args) throws Exception {

    // Dersom rmi-registeret og tjenerprogrammet kj�rer p� en annen maskin, m� IP-adressen eller
    // maskinnavnet settes inn i stedet for localhost p� neste linje.
    Konto olesKonto = (Konto) Naming.lookup("rmi://localhost/OleSinKonto");


    System.out.println(olesKonto.lagUtskrift());

    String bel�pLest = showInputDialog("Oppgi bel�p, avslutt med blank");
    while (!bel�pLest.equals("")) {
      double bel�p = Double.parseDouble(bel�pLest); //ingen feilkontroll
      olesKonto.gj�rTransaksjon(bel�p);
      System.out.println(olesKonto.lagUtskrift());
      bel�pLest = showInputDialog("Oppgi bel�p, avslutt med blank");
    }
  }
}