package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.School;
import be.intecbrussel.repository.SchoolRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class SchoolService {
    private SchoolRepository schoolRepo = new SchoolRepository();

    // CREATE : Voeg een nieuwe School toe
    public void createSchool(School school) {
        EntityManager em = JpaConfig.getEntityManager();
        schoolRepo.createSchool(em, school);
        em.close();
    }

    // READ : Zoek School op Id
    public School readSchool(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        School schools = schoolRepo.findSchoolById(em, id);
        em.close();
        return schools;
    }

    // READ : Haal alle scholen op
    public List<School> readAllSchools() {
        EntityManager em = JpaConfig.getEntityManager();
        List<School> schools = schoolRepo.findAllSchools(em);
        em.close();
        return schools;
    }

    // UPDATE : Werk School bij
    public void updateSchool(School school) {
        EntityManager em = JpaConfig.getEntityManager();
        schoolRepo.updateSchool(em, school);
        em.close();
    }

    // DELETE : Verwijder school op Id
    public void deleteSchool(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        schoolRepo.deleteSchool(em, id);
        em.close();
    }
}
