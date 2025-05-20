import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;

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

}
