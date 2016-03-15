package Oving3.KontoRMI;//
// Leksjon 2, katalog KontoRMI
// Konto.java E.L. 2003-09-03
//

import java.rmi.*;
interface Konto extends Remote {
  long finnKontonr() throws RemoteException;
  String finnNavn() throws RemoteException;
  double finnSaldo() throws RemoteException;
  void gj�rTransaksjon(double bel�p) throws RemoteException;
}

