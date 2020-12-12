package denis.ansah.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.query.Query;

import denis.ansah.POJO.User;


public class DAOUtils  extends BaseDAO{
	
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try {
            beginTransaction();
            Query<User> q = getSession().createQuery("from User", User.class);
            users = q.list();
        } catch (HibernateException e) {
            rollbackTransaction();
        } finally {
            close();
        }
        return users;
    }
    
    public User getUser(Integer id) {
        User user = null;
        try {
            beginTransaction();
            user = getSession().find(User.class, id);
            commit();
        } catch (HibernateException e) {
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }       
        return user;
    }
    
    public int addUser(User user) {
         int result = 0;
         try {
			beginTransaction();
			getSession().save(user);
			commit();
			result = 1;
         } 
         catch (HibernateException e) { getSession().getTransaction().rollback(); }
         finally { getSession().close(); } 
         return result;
    }
    
    public int deleteUser(Integer id) {
    	int result = 0;
        try {
			beginTransaction();
			User user = getSession().find(User.class, id);
			getSession().delete(user);
			commit();
			result = 1;
        } 
        catch (HibernateException e) { getSession().getTransaction().rollback(); }
        finally { getSession().close(); } 
        return result;
    }
    
    public int updateUser(Integer id, String username) {
    	int result = 0;
        try {
			beginTransaction();
			User user = getSession().find(User.class, id);
			user.setUsername(username);
			getSession().update(user);
			commit();
			result = 1;
        } 
        catch (HibernateException e) { getSession().getTransaction().rollback(); }
        finally { getSession().close(); } 
        return result;
    }

}
