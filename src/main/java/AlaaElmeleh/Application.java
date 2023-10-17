package AlaaElmeleh;
import entities.GestioneEventi;
import entities.GestioneEventiDAO;
import entities.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1-w3-d2");
    // "u3-w3-d2" DEVE essere il nome dato alla persistence-unit nel file persistence.xml

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try{
     GestioneEventiDAO prova = new GestioneEventiDAO(em);


// ESEMPIO COSTRUTTORE E SAVE
//           SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//           Date dataEvento = null;
//               dataEvento = dateFormat.parse("2024-10-17");
//    GestioneEventi eventoDaCancellare = new GestioneEventi("eventoDaCancellare ",dataEvento,"festaaaaaaaaa", TipoEvento.PRIVATO, 80);
//      prova.save(eventoDaCancellare);

////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////

// Metodo getbyid e delete
GestioneEventi eventoFromDb = prova.getById(9);
//            System.out.println(eventoFromDb);
//prova.deleteById(9);


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Metodo refresh
            GestioneEventi eventoFromDb2 = prova.getById(6);
            if(eventoFromDb2!= null){
                eventoFromDb2.setTitolo("Titolo CAMBIATO E REFRESHATO");
                System.out.println(eventoFromDb2);
                em.refresh(eventoFromDb2);
                System.out.println(eventoFromDb2);
            }



    }
    catch (Exception ex){
        System.out.println(ex.getMessage());}
        finally {
            em.close();
            emf.close();
        }
        }
    }
