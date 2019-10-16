package com.wdr.hibernate;

import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDelete {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            int id = 1;

            session.beginTransaction();

            //find Instructor by Id
            Instructor instructor = session.get(Instructor.class,id);

            //delete the found instructor
            if(instructor != null){
                session.delete(instructor);
            }

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }

    }
}
