import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDAO {
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestioneeventi");
private EntityManager em= emf.createEntityManager();
public void save(Location location){
    em.getTransaction().begin();
    em.persist(location);
    em.getTransaction().commit();
 }
public Location getById(int id){
    return em.find(Location.class,id);

}
public void remove(int id){
    Location location= getById(id);
    if (location!= null){
        em.getTransaction().begin();
        em.remove(location);
        em.getTransaction().commit();
    }
}
}
