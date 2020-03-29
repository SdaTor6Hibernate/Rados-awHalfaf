package model.UserDAO;

import model.User;
import org.hibernate.Session;
import util.HibernateUtil;

public class UserDAO{
    public void insert(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.persist(user);
        session.flush();
        session.close();
    }
    public User select(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = new User();
        user.setUserID(id);
        session.flush();
        session.close();
        return user;
    }
    public void update(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User userUpdate = new User();
        userUpdate.setUserID(user.getUserID());
        userUpdate.setAddress(user.getAddress());
        userUpdate.setBirthDate(user.getBirthDate());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setPassword(user.getPassword());
        session.update(user);
        session.flush();
        session.close();

    }
    public void delete(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User userToBeDeleted = new User();
        if (session.contains(user)) {
            user.setUserID(18);
        }
        session.delete(userToBeDeleted);
        session.flush();
        session.close();
    }


}
