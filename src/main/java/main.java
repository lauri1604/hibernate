import entity.Card;
import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        //Students
        Student s1 = new Student();
        s1.setName("Pepe");
        s1.setDni("11111111A");
        s1.setPhone("123456789");

        Student s2 = new Student();
        s2.setName("Ana");
        s2.setDni("22222222B");
        s2.setPhone("987654321");


        //Cards
        Card c1 = new Card();
        c1.setCode("CARD001");
        c1.setStudent(s1);
        s1.setCard(c1);

        Card c2 = new Card();
        c2.setCode("CARD002");
        c2.setStudent(s2);
        s2.setCard(c2);


        //Course
        Course course = new Course();
        course.setDescription("Curso de Java");
        course.setBeginDate(LocalDate.now());
        course.setEndDate(null);

        s1.getCourses().add(course);
        s2.getCourses().add(course);

        //Persistir
        em.persist(course);
        em.persist(s1);
        em.persist(s2);
        em.persist(c1);
        em.persist(c2);

        em.getTransaction().commit();
        em.close();
        emf.close();

    }
}
