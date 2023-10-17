package AlaaElmeleh;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="eventi")
public class GestioneEventi {
    @Id
    @GeneratedValue
        private int id;  // Chiave primaria
        private String titolo;
        private Date dataEvento;
        private String descrizione;
        @Enumerated(EnumType.STRING)
        private TipoEvento tipoEvento;
        private int numeroMassimoPartecipanti;

        public GestioneEventi(int id, String titolo, Date dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti) {
            this.id = id;
            this.titolo = titolo;
            this.dataEvento = dataEvento;
            this.descrizione = descrizione;
            this.tipoEvento = tipoEvento;
            this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        }

        // Metodi getter e setter per le proprietà
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitolo() {
            return titolo;
        }

        public void setTitolo(String titolo) {
            this.titolo = titolo;
        }

        public Date getDataEvento() {
            return dataEvento;
        }

        public void setDataEvento(Date dataEvento) {
            this.dataEvento = dataEvento;
        }

        public String getDescrizione() {
            return descrizione;
        }

        public void setDescrizione(String descrizione) {
            this.descrizione = descrizione;
        }

        public TipoEvento getTipoEvento() {
            return tipoEvento;
        }

        public void setTipoEvento(TipoEvento tipoEvento) {
            this.tipoEvento = tipoEvento;
        }

        public int getNumeroMassimoPartecipanti() {
            return numeroMassimoPartecipanti;
        }

        public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
            this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
        }
        @Override
    public String toString(){
            return"Event{"+ "id="+id+ "titolo="+titolo + "data="+dataEvento+ "descrizione= "+ descrizione + "tipo Evento = "+ tipoEvento + "Numero massimo partecipanti = " + numeroMassimoPartecipanti + "}";
    }
    }

