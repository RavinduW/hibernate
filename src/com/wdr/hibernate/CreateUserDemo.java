package com.wdr.hibernate;

import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateUserDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            User user = new User("ravindu", "weerasinghe", "raviduchinthaka3@gmail.com");

            //start the transaction
            session.beginTransaction();

            //save the user object
            session.save(user);

            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }
    }
}
