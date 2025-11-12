package be.intecbrussel.repository;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.School;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SchoolRepository {
    private EntityManager em = JpaConfig.getEntityManager();

    // CREATE : Voeg een nieuwe School toe
    public void createSchool(EntityManager em, School school) {
        em.getTransaction().begin();
        em.persist(school);
        em.getTransaction().commit();
    }

    // READ : Zoek school op ID
    public School findSchoolById(EntityManager em, int id) {
        return em.find(School.class, id);
    }

    // READ : Haal alle Schools op
    public List<School> findAllSchools(EntityManager em) {
        return em.createQuery("SELECT s FROM School s", School.class).getResultList();
    }

    // UPDATE : Werk School bij
    public void updateSchool(EntityManager em, School school) {
        em.getTransaction().begin();
        em.merge(school);
        em.getTransaction().commit();
    }

    // DELETE : Verwijder School op Id
    public void deleteSchool(EntityManager em, int id) {
        em.getTransaction().begin();
        School school = em.find(School.class, id);
        if (school != null) {
            em.remove(school);
        }
        em.getTransaction().commit();
    }
}
