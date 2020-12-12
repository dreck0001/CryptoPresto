package denis.ansah.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BaseDAO {
//    private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    SessionFactory sf = new Configuration().configure("/denis/ansah/config/hibernate.cfg.xml").buildSessionFactory();
    private Session session = null;

    public Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sf.openSession();
        }
        return session;
    }

    public void beginTransaction() {
        getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void close() {
        getSession().close();
    }

    public void rollbackTransaction() {
        getSession().getTransaction().rollback();
    }
}
