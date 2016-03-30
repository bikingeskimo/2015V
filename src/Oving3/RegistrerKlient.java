package Oving3;

import java.rmi.Naming;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Created by Ane on 07.03.2016.
 */
public class RegistrerKlient {
    public static final int ok = -1;
    public static final int ugyldigNr = -2;
    public static final int ikkeNokPaaLager = -3;

    public static void main(String[] args) throws Exception{
        String objektnavn ="registerobj";
        String maskinnavn = "localhost";
        String url = "rmi://" + maskinnavn + "/"+objektnavn;

        Register reg = (Register) Naming.lookup(url);

        String varer = reg.lagDatabeskrivelse();
        System.out.println(varer);
        javax.swing.JOptionPane.showMessageDialog(null, varer);

        String meny = "Velg varenr - 0 = Exit\n****************** \n"+varer;
        int valg = Integer.parseInt(showInputDialog(meny));
        while(valg != 0) {

            int antall = Integer.parseInt(showInputDialog("Oppgi ny lagerbeholdning"));

            String message = "";
            int code = reg.endreLagerbeholdning(valg, antall);
            if(code == ok) message = "OK";
            else if(code == ugyldigNr) message = "Ugyldig nr";
            else if(code == ikkeNokPaaLager) message = "Ikke nok på lager";

            System.out.println(reg.lagDatabeskrivelse());


            valg = Integer.parseInt(showInputDialog(message+"\nVelg varenr - 0 = Exit\n" +
                    "****************** \n"+reg.lagDatabeskrivelse()));
        }

        System.out.println(reg.lagDatabeskrivelse());

        /*String klientnavn = showInputDialog(null, "Oppgi klientnavn:");
        System.out.println("Her er kontrollvinduet til: " + klientnavn);
        */
    }
}
