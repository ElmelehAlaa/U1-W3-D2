package AlaaElmeleh;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u1-w3-d2");
    // "u3-w3-d2" DEVE essere il nome dato alla persistence-unit nel file persistence.xml

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dataEvento = null;
            try {
                dataEvento = dateFormat.parse("2024-10-17");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        GestioneEventiDAO prova = new GestioneEventiDAO(em);

        GestioneEventi FestaPaese = new GestioneEventi(1,"Festa",dataEvento,"festino privato", TipoEvento.PUBBLICO, 50);

    }
    catch (Exception ex){
        System.out.println(ex.getMessage());}finally {
            em.close();
            emf.close();
        }
        }
    }
