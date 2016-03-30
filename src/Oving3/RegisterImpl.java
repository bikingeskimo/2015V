package Oving3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
 * Klassen Utstyr er mutabel. Antall p? lager og nedre grense for
 * bestilling kan endres.
 */
class Utstyr{
    public static final int bestillingsfaktor = 5;
    private int nr;  // entydig identifikasjon
    private String betegnelse;
    private String leverandor;
    private int paaLager;     // mengde p? lager
    private int nedreGrense;

    public Utstyr(int startNr, String startBetegnelse, String startLeverandor,
                  int startPaaLager, int startNedreGrense){
        nr = startNr;
        betegnelse = startBetegnelse;
        leverandor = startLeverandor;
        paaLager = startPaaLager;
        nedreGrense = startNedreGrense;
    }

    public int finnNr() {
        return nr;
    }

    public String finnBetegnelse() {
        return betegnelse;
    }

    public String finnLeverandor() {
        return leverandor;
    }

    public int finnPaaLager() {
        return paaLager;
    }

    public int finnNedreGrense() {
        return nedreGrense;
    }

    public int finnBestKvantum(){
        if (paaLager < nedreGrense) return bestillingsfaktor * nedreGrense;
        else return 0;
    }

    /*
     * Endringen kan v?re positiv eller negativ. Men det er ikke
     * mulig ? ta ut mer enn det som fins p? lager. Hvis klienten
     * pr?ver p? det, vil metoden returnere false, og intet uttak gj?res.
     */
    public synchronized boolean endreLagerbeholdning(int endring) {
        System.out.println("Endrer lagerbeholdning, utstyr nr " + nr + ", endring: " + endring);
        if (paaLager + endring < 0) return false;
        else {
            paaLager += endring;
            return true;
        }
    }

    public synchronized void settNedreGrense(int nyNedreGrense) {
        nedreGrense = nyNedreGrense;
    }

    public String toString() {
        String resultat = "Nr: " + nr + ", " +
                "Betegnelse: " + betegnelse + ", " + "Leverandor: " +
                leverandor + ", " + "Paa lager: " + paaLager + ", " +
                "Nedre grense: " + nedreGrense;
        return resultat;
    }
}

/*
 *
 * Et register holder orden p? en mengde Utstyrsobjekter. En klient kan legge inn nye
 * Utstyr-objekter i registeret, og ogs? endre varebeholdningen for et
 * allerede registrert objekt. Bestillingsliste for alle varene kan lages.
 */
class RegisterImpl extends UnicastRemoteObject implements Register{
    public static final int ok = -1;
    public static final int ugyldigNr = -2;
    public static final int ikkeNokPaaLager = -3;

    public RegisterImpl() throws RemoteException{}

    private ArrayList<Utstyr> registeret = new ArrayList<Utstyr>();

    public synchronized boolean regNyttUtstyr(int startNr, String startBetegnelse,
                                 String startLeverandor, int startPaaLager,
                                 int startNedreGrense) throws RemoteException {
        if (finnUtstyrindeks(startNr) < 0) { // fins ikke fra f?r
            Utstyr nytt = new Utstyr(startNr, startBetegnelse, startLeverandor,
                    startPaaLager, startNedreGrense);
            registeret.add(nytt);
            return true;
        } else return false;
    }

    public synchronized int endreLagerbeholdning(int nr, int mengde) throws RemoteException {
        int indeks = finnUtstyrindeks(nr);
        if (indeks < 0) return ugyldigNr;
        else {
            if (!(registeret.get(indeks)).endreLagerbeholdning(mengde)) {
                return ikkeNokPaaLager;
            } else return ok;
        }
    }

    public int finnUtstyrindeks(int nr) {
        for (int i = 0; i < registeret.size(); i++) {
            int funnetNr = (registeret.get(i)).finnNr();
            if (funnetNr == nr) return i;
        }
        return -1;
    }

    public synchronized String lagBestillingsliste() {
        String resultat = "\n\nBestillingsliste:\n";
        for (int i = 0; i < registeret.size(); i++) {
            Utstyr u = registeret.get(i);
            resultat += u.finnNr() + ", " + u.finnBetegnelse() + ": " +
                    u.finnBestKvantum() + "\n";
        }
        return resultat;
    }

    public synchronized String lagDatabeskrivelse() {
        String resultat = "Alle data:\n";
        for (int i = 0; i < registeret.size(); i++) {
            resultat += (registeret.get(i)).toString() + "\n";
        }
        return resultat;
    }

}