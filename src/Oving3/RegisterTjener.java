package Oving3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Created by Ane on 07.03.2016.
 */
public class RegisterTjener {
    public static void main(String[] args) throws Exception{
        LocateRegistry.createRegistry(1099);

        String objektnavn = "registerobj";
        System.out.println("Dette er fra tjenersiden.");
        Register reg = new RegisterImpl();
        System.out.println("Registreringsobjekt opprettet");
        Naming.rebind(objektnavn, reg);
        System.out.println("Venter på klient...");
       // javax.swing.JOptionPane.showMessageDialog(null, "Trykk OK for å stoppe tjener");

        reg.regNyttUtstyr(1,"Mobil", "Sony", 30, 5);
        reg.regNyttUtstyr(2,"Stol", "Jensen", 4, 12);
        reg.regNyttUtstyr(3,"Bord", "Jensen", 21, 20);
        reg.regNyttUtstyr(4,"Hekkesaks", "Blekk", 23, 50);
        reg.regNyttUtstyr(5,"Margaritas", "SeniorFrog", 4, 10);

       //Naming.unbind(objektnavn);
       // System.exit(0);
        while (true){

        }

    }
}
