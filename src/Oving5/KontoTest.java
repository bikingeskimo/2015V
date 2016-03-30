/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oving5;

import java.rmi.*;
import java.util.List;


public class KontoTest {
    public static void main(String[] args){
        try{

            String url = "rmi://localhost/kontoFasade";
            KontoFasade fasade = (KontoFasade) Naming.lookup(url);

            Konto konto = new Konto();
            /*konto.setKontonr("1111");
            konto.setSaldo(2000);
            konto.setEier("Per Normann");
            konto.setLaasing(0);
            fasade.lagreNyKonto(konto);
            System.out.println("OK");*/

            konto = new Konto("1112", 500, "Olav Normann", 0);
            fasade.lagreNyKonto(konto);
            System.out.println("OK");

            konto = new Konto("1113", 1500, "Kari Normann", 0);
            fasade.lagreNyKonto(konto);
            //System.out.println("OK");

            konto = new Konto("2112", 12600, "Magda Normann", 0);
            fasade.lagreNyKonto(konto);
            // System.out.println("OK");


            //lister ut alle kontoer med saldogrense
            double saldoG = 1000;
            System.out.println("Liste over alle med saldo over " + saldoG + " kr.");
            List<Konto> liste = fasade.getAlleKonti(saldoG);
            for(Konto k : liste) System.out.println(k);

            //lister ut alle kontoer
            System.out.println("Liste over alle kontoer i DB: ");
            liste = fasade.getAlleKonti();
            for(Konto k: liste)  System.out.println("----" + k);


            //endrer på en konto
            konto = (Konto) liste.get(0);
            konto.setEier("Ola Normann");
            fasade.endreKonto(konto);

            //overføring
            fasade.overfor((Konto)liste.get(0), (Konto)liste.get(1), 1001);
            fasade.overfor((Konto)liste.get(0), (Konto)liste.get(2), 30);


            //lister ut alle kontoer
            System.out.println("Liste over alle kontoer i DB: ");
            liste = fasade.getAlleKonti();
            for(Konto k: liste)  System.out.println("----" + k);



        }catch(Exception e){
            System.out.println(e);
        }
    }
}
