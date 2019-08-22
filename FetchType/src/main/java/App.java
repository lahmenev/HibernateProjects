import com.hibernate.entity.Address;
import com.hibernate.entity.UserDetails;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public class App {
    private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    public static void main(String[] args) {
        UserDetails user = new UserDetails();
        user.setName("Sergg");

        Address address1 = new Address();
        address1.setCity("SPb");
        address1.setStreet("Kondratievsky");

        Address address2 = new Address();
        address2.setCity("Msk");
        address2.setStreet("Pushkinskay");

        user.getAddressList().add(address1);
        user.getAddressList().add(address2);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.persist(user);
        session.getTransaction().commit();
        session.close();

        user = null;

        session = sessionFactory.openSession();

        // - if we enable eager fetchType: we get select with join (retrieves all data from tables)
        // - if we apply lazy fetchType (default): we get only user information (select * from UserDetails) without joins
        user = session.get(UserDetails.class, 1);
        System.out.println(user);

        session.close();
        // Here we get lazyInitialization exception if we have lazy fetch Type
        System.out.println(user.getAddressList().size());
    }
}
