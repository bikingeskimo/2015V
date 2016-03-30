package Oving3;

import java.rmi.*;

/**
 * Created by Ane on 07.03.2016.
 */
public interface Register extends Remote {
    boolean regNyttUtstyr(int startNr, String startBetegnelse,
                          String startLeverandor, int startPaaLager,
                          int startNedreGrense) throws RemoteException;
    int endreLagerbeholdning(int nr, int mengde) throws RemoteException;
    int finnUtstyrindeks(int nr) throws RemoteException;
    String lagBestillingsliste() throws RemoteException;
    String lagDatabeskrivelse() throws RemoteException;

}
