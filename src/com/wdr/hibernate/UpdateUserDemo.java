package com.wdr.hibernate;

import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateUserDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int userId = 1;

            //update the user's firstname
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class,userId);
            user.setFirstName("dinu");
            session.getTransaction().commit();

            //bulk update
            session = factory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("UPDATE User set email = 'ravinducw@gmail.com'")
                    .executeUpdate();
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }
    }
}
