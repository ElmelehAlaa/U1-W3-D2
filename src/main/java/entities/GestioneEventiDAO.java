package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
public class GestioneEventiDAO {
    private final EntityManager em;

    public GestioneEventiDAO(EntityManager em){
        this.em=em;
    }
    public   void save(GestioneEventi gestioneEventi){
        try{
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(gestioneEventi);

        transaction.commit();
        System.out.println("Evento salvato correttamente!");
    }catch (Exception ex){
            System.out.println(ex.getMessage());
        }}
    public GestioneEventi getById(int id){
        return em.find(GestioneEventi.class,id);
    }

    public void deleteById(int id){
        GestioneEventi found = em.find(GestioneEventi.class, id);
        if(found != null){
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            em.remove(found);
            transaction.commit();
            System.out.println("Evento cancellato!");}else {
            System.out.println("L'evento con l'id:" + id + "non è stato trovato");
        }
    }
    public void refresh(GestioneEventi gestioneEventi) {
        em.refresh(gestioneEventi);
    }
}
