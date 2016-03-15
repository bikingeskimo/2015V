package Oving3.KontoRMIMedFabrikk;
//
// Leksjon 2, katalog KontoRMIMedFabrikk
// Konto.java E.L. 2003-09-04
//

import java.rmi.*;

interface Konto extends Remote {
  long finnKontonr() throws RemoteException;
  String finnNavn() throws RemoteException;
  double finnSaldo() throws RemoteException;
  void gj�rTransaksjon(double bel�p) throws RemoteException;
}

