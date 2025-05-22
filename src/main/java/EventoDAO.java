import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class EventoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    private EntityManager em;

    public EventoDAO() {
        this.em = emf.createEntityManager();
    }
    public void save(Evento evento){
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento getById(int id){
        return em.find(Evento.class,id);
    }

    public void remove(int id){
        Evento e= getById(id);
        if (e!= null){
            em.getTransaction().begin();
            em.remove(e);
            em.getTransaction().commit();
        }else {
            System.out.println("evento con id: "+ id + " non trovato");
        }
    }
    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.inStreaming = :inStreaming", Concerto.class);
        query.setParameter("inStreaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio>getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query= em.createNamedQuery("getPartiteVinteInCasa",PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }
public List<GaraDiAtletica>getGaraDiAtleticaPerVincitore(Persona vincitore){
        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where g.vincitore = :vincitore",GaraDiAtletica.class);
query.setParameter("vincitore",vincitore);
return query.getResultList();
    }

    public List<GaraDiAtletica>getGaraDiAtleticaPerPartecipante(Persona partecipante){
        TypedQuery<GaraDiAtletica> query= em.createQuery("select g from GaraDiAtletica g where :partecipante MEMBER OF g.atleti",GaraDiAtletica.class);
        query.setParameter("partecipante",partecipante);
        return query.getResultList();
    }
    public List<Evento> getEventiSoldOut(){
    TypedQuery<Evento> query= em.createQuery("select e from Evento e ehere e.partecipazioni.size()=e.NumeroMassimoPartecipanti",Evento.class);
    return query.getResultList();
    }
}
