import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PartecipazioneDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");
    private EntityManager em = emf.createEntityManager();

    public void save(Partecipazione partecipazione) {
        em.getTransaction().begin();
        em.persist(partecipazione);
        em.getTransaction().commit();
    }

    public Partecipazione getById(int id) {
        return em.find(Partecipazione.class, id);
    }

    public void remove(int id) {
        Partecipazione partecipazione = getById(id);
        if (partecipazione != null) {
            em.getTransaction().begin();
            em.remove(partecipazione);
            em.getTransaction().commit();
        }
    }
}