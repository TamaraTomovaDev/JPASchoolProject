package be.intecbrussel;

import be.intecbrussel.config.JpaConfig;
import be.intecbrussel.model.School;
import be.intecbrussel.model.Student;
import be.intecbrussel.model.Teacher;
import be.intecbrussel.service.SchoolService;
import be.intecbrussel.service.StudentService;
import be.intecbrussel.service.TeacherService;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Start JPA School Demo ===");

        // Initialiseer services
        SchoolService schoolService = new SchoolService();
        TeacherService teacherService = new TeacherService();
        StudentService studentService = new StudentService();

        // CREATE
        System.out.println("--- CREATE ---");

        // Maak School
        School school = new School();
        school.setName("Intec Brussel");
        school.setCity("Brussel");
        schoolService.createSchool(school);
        System.out.println("School aangemaakt: " + school.getName());

        // Maak Teachers
        Teacher hilal = new Teacher();
        hilal.setFirstName("Hilal");
        hilal.setLastName("Demir");
        hilal.setSchool(school);

        Teacher teodora = new Teacher();
        teodora.setFirstName("Teodora");
        teodora.setLastName("Mladenovic");
        teodora.setSchool(school);

        Teacher hanae = new Teacher();
        hanae.setFirstName("Hanae");
        hanae.setLastName("Zaini");
        hanae.setSchool(school);

        teacherService.createTeacher(hilal);
        teacherService.createTeacher(teodora);
        teacherService.createTeacher(hanae);
        System.out.println("Teachers aangemaakt: Hilal Demir, Teodora Mladenovic, Hanae Zaini");

        // Voeg teachers toe aan school en update
        school.getTeachers().addAll(Arrays.asList(hilal, teodora, hanae));
        schoolService.updateSchool(school);

        // Maak Students
        Student tamara = new Student();
        tamara.setFirstName("Tamara");
        tamara.setLastName("Tomova");
        tamara.setSchool(school);
        tamara.getTeachers().addAll(Arrays.asList(hilal, teodora, hanae));

        Student annelies = new Student();
        annelies.setFirstName("Annelies");
        annelies.setLastName("Peeters");
        annelies.setSchool(school);
        annelies.getTeachers().add(hilal);

        Student victoria = new Student();
        victoria.setFirstName("Victoria");
        victoria.setLastName("Martens");
        victoria.setSchool(school);
        victoria.getTeachers().add(teodora);

        Student eva = new Student();
        eva.setFirstName("Eva");
        eva.setLastName("Janssens");
        eva.setSchool(school);
        eva.getTeachers().add(hanae);

        Student sheyma = new Student();
        sheyma.setFirstName("Sheyma");
        sheyma.setLastName("Karaca");
        sheyma.setSchool(school);
        sheyma.getTeachers().addAll(Arrays.asList(hilal, hanae));

        // Opslaan in database
        studentService.createStudent(tamara);
        studentService.createStudent(annelies);
        studentService.createStudent(victoria);
        studentService.createStudent(eva);
        studentService.createStudent(sheyma);
        System.out.println("Students aangemaakt: Tamara, Annelies, Victoria, Eva, Sheyma");

        // Voeg students toe aan school en update
        school.getStudents().addAll(Arrays.asList(tamara, annelies, victoria, eva, sheyma));
        schoolService.updateSchool(school);

        // READ
        System.out.println("\n--- READ ---");

        System.out.println("\nAlle scholen:");
        schoolService.readAllSchools().forEach(sc ->
                System.out.println(sc.getName() + " - " + sc.getCity()));

        System.out.println("\nAlle teachers:");
        teacherService.readAllTeacher().forEach(t ->
                System.out.println(t.getFirstName() + " " + t.getLastName()));

        System.out.println("\nAlle studenten:");
        studentService.readAllStudents().forEach(s ->
                System.out.println(s.getFirstName() + " " + s.getLastName()));

        // UPDATE
        System.out.println("\n--- UPDATE ---");
        tamara.setLastName("Tomova-Updated");
        studentService.updateStudent(tamara);
        System.out.println("Student geüpdatet: " + studentService.readStudent(tamara.getId()).getLastName());

        // DELETE
        System.out.println("\n--- DELETE ---");
        Student savedSheyma = studentService.readStudent(sheyma.getId());
        studentService.deleteStudent(savedSheyma.getId());
        System.out.println("Student verwijderd: " + savedSheyma.getFirstName() + " " + savedSheyma.getLastName());

        // Sluit EntityManagerFactory
        JpaConfig.close();
    }
}