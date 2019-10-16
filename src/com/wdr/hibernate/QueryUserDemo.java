package com.wdr.hibernate;

import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryUserDemo {
    public static void main(String[] args) {        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            //start the transaction
            session.beginTransaction();

            List<User> listOfUsers = session.createQuery("from User").list();

            for(User user:listOfUsers){
                System.out.println(user);
            }

            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }
    }

}
