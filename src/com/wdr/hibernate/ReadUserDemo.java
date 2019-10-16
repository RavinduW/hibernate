package com.wdr.hibernate;

import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadUserDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            //start the transaction
            session.beginTransaction();

            //retrieve the user object
            User user = session.get(User.class,2);

            System.out.println(user.getEmail());

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }
    }
}
