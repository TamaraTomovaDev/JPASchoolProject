package be.intecbrussel.repository;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Teacher;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TeacherRepository {
    private EntityManager em = JpaConfig.getEntityManager();

    // CREATE : Voeg een nieuwe Teacher toe
    public void createTeacher(EntityManager em, Teacher teacher) {
        em.getTransaction().begin();
        em.persist(teacher);
        em.getTransaction().commit();
    }

    // READ : Zoek een Teacher op Id
    public Teacher findTeacherbyId(EntityManager em, int id) {
        return em.find(Teacher.class, id);
    }

    // READ : Haal alle Teahers op
    public List<Teacher> findAllTeacher(EntityManager em) {
        return em.createQuery("SELECT t FROM Teacher t", Teacher.class).getResultList();
    }

    // UPDATE : Werk Teacher bij
    public void updateTeacher(EntityManager em, Teacher teacher) {
        em.getTransaction().begin();
        em.merge(teacher);
        em.getTransaction().commit();
    }

    // DELETE : Verwijder Teacher op Id
    public void deleteTeacher(EntityManager em, int id) {
        em.getTransaction().begin();
        Teacher teacher = em.find(Teacher.class, id);
        if(teacher!=null) {
            em.remove(teacher);
        }
        em.getTransaction().commit();
    }
}
