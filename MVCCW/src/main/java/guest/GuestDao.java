package guest;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GuestDao {

    // Injected database connection:
    @PersistenceContext
    private EntityManager em;

    // Stores a new guest:
    @Transactional
    public void persist(Guest guest) {
        em.persist(guest);
    }

    // Retrieves all the guests:
    public List<Guest> getAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
                  "SELECT g FROM Guest g ORDER BY g.id", Guest.class);
//        query.setMaxResults(5);
//        List<Guest> blah = query.getResultList();
//
//blah.clear();
        return query.getResultList();
    }

    public Long getCount() {
        TypedQuery<Long> query = em.createQuery(
                "SELECT Count(g) FROM Guest g", Long.class);
        return query.getSingleResult();
    }

    // Retrieves all the guests:
    public List<Guest> removeAllGuests() {
        TypedQuery<Guest> query = em.createQuery(
                "DELETE Count(g) FROM Guest g ", Guest.class);
        List<Guest> blah = query.getResultList();

blah.clear();
        return query.getResultList();
        
    }
}
