/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Oving5;

import java.util.List;
import javax.persistence.*;

public class KontoDAO {
    private EntityManagerFactory emf;
    
    public KontoDAO(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public void lagreNyKonto(Konto konto){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            em.persist(konto);//fører boka inn i lagringskontekt (persistence context)
            //System.out.println();
            em.getTransaction().commit();//lagring skjer her
        }finally{
            lukkEM(em);
        }
    }
   
     public Konto finnKonto(String kontonr){
        EntityManager em = getEM();
        try{
            return em.find(Konto.class, kontonr);
        }finally{
            lukkEM(em);
        }
    }
     
    public void endreKonto(Konto konto){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            Konto k = em.merge(konto);//sørger for å føre entiteten inn i lagringskonteksten
            em.getTransaction().commit();//merk at endringene gjort utenfor transaksjonen blir lagret!!!
        }finally{
            lukkEM(em);
        }
    }
      
    public List<Konto> getAlleKonti(){
        EntityManager em = getEM();
        try{
            Query q = em.createQuery("SELECT OBJECT(o) FROM Konto o");
            //SELECT o FROM BOK o gir samme resultat
            //MERK at Bok må ha stor B (samme som klassenavn)
            return q.getResultList();
        }finally{
            lukkEM(em);
        }
    }
    
    public List<Konto> getAlleKonti(double grense){
        EntityManager em = getEM();
        try{
            Query q = em.createQuery("SELECT OBJECT(o) FROM Konto o WHERE o.saldo > " + grense);
            //SELECT o FROM BOK o gir samme resultat
            //MERK at Bok må ha stor B (samme som klassenavn)
            return q.getResultList();
        }finally{
            lukkEM(em);
        }
    }
    
    public void overfor(Konto k1, Konto k2, double sum){
        EntityManager em = getEM();
        try{
            em.getTransaction().begin();
            k1.trekkBelop(sum);
            k2.trekkBelop(-sum);
            
            em.merge(k1);
            em.merge(k2);
            
            em.getTransaction().commit();
            
        }catch(IkkeDekningException e){
            System.out.println(e);
        }
        finally{
            lukkEM(em);
        }
    }
     
    private EntityManager getEM(){
        return emf.createEntityManager();
    }
    
    private void lukkEM(EntityManager em){
        if (em != null && em.isOpen()) em.close();
    }
}
