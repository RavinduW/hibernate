package com.wdr.hibernate;

import com.wdr.entities.Course;
import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import com.wdr.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDemo {
    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            Instructor newInstructor = new Instructor("janidu","gunathilaka","jur@gmail.com");
            InstructorDetail newInstructorDetail = new InstructorDetail("cloud","cloud computing");

            newInstructor.setInstructorDetail(newInstructorDetail);

            session.beginTransaction();

            session.save(newInstructor);

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
            factory.close();
        }
    }
}
