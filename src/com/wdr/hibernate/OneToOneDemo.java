package com.wdr.hibernate;

import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(InstructorDetail.class)
                                    .addAnnotatedClass(Instructor.class).buildSessionFactory();

        Session session = factory.getCurrentSession();

        try{
            Instructor newInstructor = new Instructor("ravindu","weerasinghe","ravinduweerasinghe@gmail.com");
            InstructorDetail newInstructorDetail = new InstructorDetail("JavaHome","coding");
            Instructor newInstructor2 = new Instructor("janidu","ranaweera","juranaweera@gmail.com");
            InstructorDetail newInstructorDetail2 = new InstructorDetail("Python","sleeping");

            System.out.println("before");
            newInstructor.setInstructorDetail(newInstructorDetail);
            newInstructor2.setInstructorDetail(newInstructorDetail2);
            System.out.println("after");

            session.beginTransaction();
            System.out.println("before INS");
            session.save(newInstructor);
            session.save(newInstructor2);
            System.out.println("after INS");
            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            factory.close();
        }

    }
}
