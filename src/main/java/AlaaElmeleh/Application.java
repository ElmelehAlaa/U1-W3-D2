package AlaaElmeleh;
import entities.*;
import entities.Enum.Sesso;
import entities.Enum.StatoPartecipazione;
import entities.Enum.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1-w3-d2");
    // "u3-w3-d2" DEVE essere il nome dato alla persistence-unit nel file persistence.xml

    public static void main(String[] args) throws ParseException {
        EntityManager em = emf.createEntityManager();
      try{
     GestioneEventiDAO prova = new GestioneEventiDAO(em);
        PersonaDAO personaDao =  new PersonaDAO(em);
        LocationDAO locationDao=new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);


//ESEMPIO COSTRUTTORE E SAVE
//          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//          Date dataEvento = null;
//              dataEvento = dateFormat.parse("2024-10-17");
//   GestioneEventi eventoDaCancellare = new GestioneEventi("eventoDaCancellare ",dataEvento,"festaaaaaaaaa", TipoEvento.PRIVATO, 80);
//     prova.save(eventoDaCancellare);

////////////////////////////////// ////////////////////////////////////////////////////////////////////////////////////////////////

// Metodo getbyid e delete
//GestioneEventi eventoFromDb = prova.getById(9);
//            System.out.println(eventoFromDb);
//prova.deleteById(9);


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Metodo refresh
//            GestioneEventi eventoFromDb2 = prova.getById(6);
//            if(eventoFromDb2!= null){
//                eventoFromDb2.setTitolo("Titolo CAMBIATO E REFRESHATO");
//                System.out.println(eventoFromDb2);
//                em.refresh(eventoFromDb2);
//                System.out.println(eventoFromDb2);
//            }



//    }
//    catch (Exception ex){
//        System.out.println(ex.getMessage());}
//        finally {
//            em.close();
//            emf.close();
//        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
          Date dataNascita = null;
          dataNascita=dateFormat.parse ("1999-10-17");
        Persona giacomo = new Persona("Giacomo","Leopardi","giacomoLeopardi@outlook.it", dataNascita, Sesso.M);
        personaDao.save(giacomo);

        Location location = new Location();
        location.setCitta("Roma");
        location.setNome("ciao");
        locationDao.save(location);


        dataNascita=dateFormat.parse ("1999-10-17");
        GestioneEventi evento = new GestioneEventi("eventoProva",dataNascita,"festaaaaaaaaa", TipoEvento.PRIVATO, 80);
        prova.save(evento);

        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setPersona(giacomo);
        partecipazione.setEvento(evento);
        partecipazione.setStatoPartecipazione(StatoPartecipazione.CONFERMATA);}catch (Exception ex){
          System.out.println(ex.getMessage());}
      finally {
          em.close();
          emf.close();
      }


        }}

