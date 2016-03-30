/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oving5;

import java.rmi.*;
import java.util.List;

/**
 *
 * @author Ane
 */
public interface KontoFasade extends Remote{
    public void lagreNyKonto(Konto konto) throws RemoteException;
    public void endreKonto(Konto konto) throws RemoteException;
    public Konto finnKonto(String kontonr) throws RemoteException;
    public List<Konto> getAlleKonti() throws RemoteException;
    public List<Konto> getAlleKonti(double grense) throws RemoteException;
    public void overfor(Konto k1, Konto k2, double sum) throws RemoteException;
    
}
