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
                "SELECT c FROM Concerto c WHERE c.inStreaming = :streaming", Concerto.class);
        query.setParameter("streaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GenereConcerto genere) {
        TypedQuery<Concerto> query = em.createQuery(
                "SELECT c FROM Concerto c WHERE c.genere = :genere", Concerto.class);
        query.setParameter("genere", genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio>getPartiteVinteInCasa(){
        TypedQuery<PartitaDiCalcio> query= em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInCasa",PartitaDiCalcio.class);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        return query.getResultList();
    }
    public List<PartitaDiCalcio> getPartitePareggiate() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("PartitaDiCalcio.getPartitePareggiate", PartitaDiCalcio.class);
        return query.getResultList();
    }



}
