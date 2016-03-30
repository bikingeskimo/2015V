/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oving5;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KontoFasadeImpl extends UnicastRemoteObject implements KontoFasade{
    private KontoDAO dao;
    
    public KontoFasadeImpl() throws RemoteException{}
    
    public KontoFasadeImpl(KontoDAO dao) throws RemoteException{
        this.dao = dao;
    }
    
    public synchronized void lagreNyKonto(Konto k) throws RemoteException{
        dao.lagreNyKonto(k);
    }
    
    public synchronized void endreKonto(Konto k) throws RemoteException{
        dao.endreKonto(k);
    }
    
    public Konto finnKonto(String nr) throws RemoteException{
        return dao.finnKonto(nr);
    }
    
    public List<Konto> getAlleKonti() throws RemoteException{
        return dao.getAlleKonti();
    }
    
    public List<Konto> getAlleKonti(double grense) throws RemoteException{
        return dao.getAlleKonti(grense);
    }
    
    public synchronized void overfor(Konto k1, Konto k2, double sum) throws RemoteException{
        dao.overfor(k1, k2, sum);
    }
    
    public static void main(String args[]) throws Exception {
        EntityManagerFactory emf = null;


        KontoFasade fasade = null;
        Registry registry = null;
        System.out.println("Starter tjener...");
        try {

            emf = Persistence.createEntityManagerFactory("Entitet1PU");
            EntityManager em = emf.createEntityManager();

            System.out.println("EntityManager og Factory opprettet...");
            registry = LocateRegistry.createRegistry(1099);//start rmiregistry
            System.out.println("RmiRegistry startet....");
            fasade = new KontoFasadeImpl(new KontoDAO(emf));
            System.out.println("Fasaden er opprettet...");
            registry.rebind("kontoFasade", fasade);
            System.out.println("Fasaden er bundet i rmiregistret...");

            javax.swing.JOptionPane.showConfirmDialog(null, "Trykk for Ã¥ avslutt tjener");

            em.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println(e);

        }
    }
}
