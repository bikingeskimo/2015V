package Oving3.LitenOppgave2;

import java.rmi.*;

interface Konto extends Remote {
  long finnKontonr() throws RemoteException;
  String finnNavn() throws RemoteException;
  double finnSaldo() throws RemoteException;
  void gj�rTransaksjon(double bel�p) throws RemoteException;
  String lagUtskrift() throws RemoteException;
}

