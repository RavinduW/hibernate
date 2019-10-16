package com.wdr.hibernate;

import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteUserDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int userId = 2;

            //update the user's firstname
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class,userId);

            if(user != null){
                session.delete(user);
            }

            session.createQuery("DELETE FROM User WHERE id=3")
                    .executeUpdate();

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }
    }
}
