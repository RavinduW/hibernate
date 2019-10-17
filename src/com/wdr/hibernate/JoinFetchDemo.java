package com.wdr.hibernate;

import com.wdr.entities.Course;
import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class JoinFetchDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            int id = 2;

            session.beginTransaction();

            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i "
                                      +"JOIN FETCH i.courses "
                                      +"WHERE i.id = :instructorId",Instructor.class);

            query.setParameter("instructorId",id);

            Instructor instructor = query.getSingleResult();

            System.out.println("Instructor ==> "+instructor);

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
            factory.close();
        }
    }
}
