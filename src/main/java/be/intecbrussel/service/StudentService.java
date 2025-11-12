package be.intecbrussel.service;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.Student;
import be.intecbrussel.repository.StudentRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentService {
    private StudentRepository studentRepo = new StudentRepository();
    // CREATE : Voeg een nieuwe student toe
    public void createStudent(Student student) {
        EntityManager em = JpaConfig.getEntityManager();
        studentRepo.createStudent(em, student);
        em.close();
    }

    // READ : Zoek Student op Id
    public Student readStudent(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        Student student = studentRepo.findStudentById(em, id);
        em.close();
        return student;
    }

    // READ : Haal alle studenten op
    public List<Student> readAllStudents() {
        EntityManager em = JpaConfig.getEntityManager();
        List<Student> students = studentRepo.findAllStudents(em);
        em.close();
        return students;
    }

    // UPDATE : Werk student bij
    public void updateStudent(Student student) {
        EntityManager em = JpaConfig.getEntityManager();
        studentRepo.updateStudent(em, student);
        em.close();
    }

    // DELETE : Verwijder student op Id
    public void deleteStudent(int id) {
        EntityManager em = JpaConfig.getEntityManager();
        studentRepo.deleteStudent(em, id);
        em.close();
    }
}
