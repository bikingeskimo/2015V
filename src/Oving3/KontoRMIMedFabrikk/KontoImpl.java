package Oving3.KontoRMIMedFabrikk;

//
// Leksjon 2, katalog KontoRMIMedFabrikk
// KontoImpl.java E.L. 2003-09-03
//
import java.rmi.*;
import java.rmi.server.*;
class KontoImpl extends UnicastRemoteObject implements Konto {
  private long   kontonr;
  private String navn;
  private double saldo;

  public KontoImpl(long startKontonr, String startNavn, double startSaldo)
      throws RemoteException {
    kontonr = startKontonr;
    navn = startNavn;
    saldo = startSaldo;
  }

  public synchronized long finnKontonr() throws RemoteException {
    return kontonr;
  }

  public synchronized String finnNavn() throws RemoteException {
    return navn;
  }

  public synchronized double finnSaldo() throws RemoteException {
    return saldo;
  }

  public synchronized void gj�rTransaksjon(double bel�p) throws RemoteException {
    saldo = saldo + bel�p;
    System.out.println("Transaksjon: " + bel�p);
  }
}

