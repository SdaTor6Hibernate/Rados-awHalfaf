import model.Country;
import org.hibernate.Session;
import util.HibernateUtil;

public class przyklad2{
    public static void main(String[] args) {
        useDelete();
    }

    public static void usePersist() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country newCountry = new Country();
        newCountry.setName("India");
        newCountry.setAlias("IN");
        session.persist(newCountry);
        session.flush();
        session.close();

    }

    public static void useMerge() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country newCountry = new Country();
        newCountry.setName("Spain");
        newCountry.setAlias("ES");
        session.merge(newCountry);
        session.flush();
        session.close();
    }

    public static void useUpdate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country country = new Country();
        country.setCountryID(2);
        country.setName("Japan");
        country.setAlias("JP");
        session.update(country);
        session.flush();
        session.close();
    }

    public static void useDelete() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Country countryToBeDeleted = new Country();
        if (session.contains(countryToBeDeleted)) {
            countryToBeDeleted.setCountryID(18);
        }
        session.delete(countryToBeDeleted);
        session.flush();
        session.close();
    }
}
