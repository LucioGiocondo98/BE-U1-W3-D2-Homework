import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersonaDAO {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestioneeventi");
    private EntityManager em= emf.createEntityManager();

    public void save(Persona persona){
        em.getTransaction().begin();
        em.persist(persona);
        em.getTransaction().commit();
    }

    public Persona getById(int id){
        return em.find(Persona.class,id);
    }

    public void remove(int id){
        Persona persona= getById(id);
        if (persona!=null){
            em.getTransaction().begin();
            em.remove(persona);
            em.getTransaction().commit();
        }else {
            System.out.println("persona con id: "+ id+ "non trovata");
        }
    }
}
