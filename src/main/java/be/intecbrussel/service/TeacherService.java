package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Teacher;
import be.intecbrussel.repository.TeacherRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TeacherService {
    private TeacherRepository teacherRepo = new TeacherRepository();

    // CREATE : Voeg een nieuwe Teacher toe
    public void createTeacher(Teacher teacher) {
        EntityManager em = JpaConfig.getEntityManager();
        teacherRepo.createTeacher(em, teacher);
        em.close();
    }

    // READ : Zoek Teacher op Id
    public Teacher readTeacher(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        Teacher teacher = teacherRepo.findTeacherbyId(em, id);
        em.close();
        return teacher;
    }

    // READ : Haal alle Teachers op
    public List<Teacher> readAllTeacher() {
        EntityManager em = JpaConfig.getEntityManager();
        List<Teacher> teachers = teacherRepo.findAllTeacher(em);
        em.close();
        return teachers;
    }

    // UPDATE : Werk Teacher bij
    public void updateTeacher(Teacher teacher) {
        EntityManager em = JpaConfig.getEntityManager();
        teacherRepo.updateTeacher(em, teacher);
        em.close();
    }

    // DELETE : Verwijder Teacher op Id
    public void deleteTeacher(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        teacherRepo.deleteTeacher(em, id);
        em.close();
    }
}
