package com.wdr.hibernate;

import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneBi {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Instructor.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{

            int id = 2;

            session.beginTransaction();

            //find Instructor by Id
            InstructorDetail instructorDetail = session.get(InstructorDetail.class,id);

            //delete the found instructor
            if(instructorDetail != null){
                System.out.println(instructorDetail.getInstructor());
            }

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
            factory.close();
        }
    }
}
