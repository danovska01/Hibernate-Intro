package my_project;

import entities.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory sessionFactory =
                cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Your Code Here

//        Student student2 = new Student( "Pesho82");
//        session.save(student2);
//
//        Student student1 = session.get(Student.class, 7);
//        System.out.println(student1);

        List<Student> studentList =
        session.createQuery("FROM Student " ,
                Student.class).list();
        for (Student student : studentList) {
            System.out.println(student.toString());
        }

        session.getTransaction().commit();
        session.close();
    }
}