package com.wdr.hibernate;

import com.wdr.entities.Course;
import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorCoursesDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {
            int id = 2;

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class,id);

            if(instructor != null){
                System.out.println("Courses of the instructor =>"+instructor.getCourses());
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
