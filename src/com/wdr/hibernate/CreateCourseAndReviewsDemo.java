package com.wdr.hibernate;

import com.wdr.entities.Course;
import com.wdr.entities.Instructor;
import com.wdr.entities.InstructorDetail;
import com.wdr.entities.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Review.class).addAnnotatedClass(Course.class).addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            Course newCourse = new Course("Machine Learning");

            newCourse.addReview(new Review("Good course"));
            newCourse.addReview(new Review("Got good understanding about ML"));

            session.save(newCourse);

            session.getTransaction().commit();

        }catch(Exception e){
            System.out.println(e);
        }finally{
            session.close();
            factory.close();
        }
    }
}
