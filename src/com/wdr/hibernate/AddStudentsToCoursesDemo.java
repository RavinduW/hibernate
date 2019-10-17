package com.wdr.hibernate;

import com.wdr.entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddStudentsToCoursesDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(User.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course newCourse = new Course("Data mining");

            session.save(newCourse);

            User student1 = new User("ravindu","chinthaka","raviduchinthaka3@gmail.com");
            User student2 = new User("manjula","nishantha","manjula@gmail.com");

            newCourse.addStudent(student1);
            newCourse.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
            factory.close();
        }
    }
}
