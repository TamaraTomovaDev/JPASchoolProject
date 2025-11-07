package be.intecbrussel.repository;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentRepository {
    private EntityManager em = JpaConfig.getEntityManager();

    // CREATE : Voeg een nieuwe Student toe aan de database
    public void createStudent(EntityManager em , Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    // READ : Zoek een student op basis van Id
    public Student findStudentById(EntityManager em , int id) {
        return em.find(Student.class, id);
    }

    // READ : Haal alle studenten op
    public List<Student> findAllStudents(EntityManager em) {
        return em.createQuery("SELECT st FROM Student st", Student.class).getResultList();
    }

    // UPDATE : Werk een bestaande student bij
    public void updateStudent(EntityManager em , Student student) {
        em.getTransaction().begin();
        em.merge(student);
        em.getTransaction().commit();
    }

    // DELETE : Verwijder een Student op basis van Id
    public void deleteStudent(EntityManager em , int id) {
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
    }
}
