package com.avoris.challenge.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StudentTest {

    private Student student;
    private List<Subject> subjects =  new ArrayList<>();;

    @BeforeEach
    public void setUp(){
        subjects.add(new Subject("MATEMATICAS", 5));
        subjects.add(new Subject("LENGUA", 10));
        student = new Student("OSCAR",22 , LocalDate.of(2022,2,10), subjects);
    }

    @Test
    @DisplayName("Este metodo valida que los datos pasados en el contructor se guardaron correctamente")
    public void whenCreateIsOk(){


        assertAll(() -> assertEquals(student.getName(), "OSCAR"),
                () -> assertEquals(student.getAge(), 22),
                () -> assertEquals(student.getEndDate(),"10/2"),
                () -> assertEquals(student.getSubjects().get(0), new Subject("MATEMATICAS", 5)),
                () -> assertEquals(student.getSubjects().get(1), new Subject("LENGUA", 10)));
    }

    @Test
    @DisplayName("Este metodo valida que no le pueden agregar materias al estudiante" +
            " en el caso de obtener la lista de materias asociadas al estudiante")
    public void whenAddNewSubjectNotModifyTheSubjectListOriginal(){
        Subject subject = new Subject("INGLES", 6);
        student.getSubjects().add(subject);

        assertFalse(student.getSubjects().contains(subject));
        assertEquals(student.getSubjects().size(), 2);

    }
    @Test
    @DisplayName("Este metodo valida que no le pueden agregar materias al estudiante" +
            "en el caso de agregarle materias a la lista que se paso en el constructor del objeto Student")
    public void whenAddNewItemToOriginalListDoNotModifyTheOriginalSubjectList(){

        Subject subject = new Subject("INGLES", 9);
        subjects.add(subject);

        assertFalse(student.getSubjects().contains(subject));
        assertEquals(student.getSubjects().size(), 2);
    }

    @Test
    @DisplayName("Este metodo valida que no le pueden modificar materias al estudiante" +
            "en el caso de modificarle una materia a la lista que se paso en el constructor del objeto Student")
    public void whenTryToModifySubjectOfTheOriginalList(){

        subjects.get(0).setGrade(7);

        assertEquals(student.getSubjects().get(0).getGrade(),5);

    }

    @Test
    @DisplayName("Este metodo valida que no le pueden modificar materias al estudiante" +
            "en el caso de obtener la lista de materias asociadas al estudiante")
    public void whenTryToModifySubjectOfTheStudentList(){

        student.getSubjects().get(0).setGrade(10);

        assertEquals(student.getSubjects().get(0).getGrade(),5);
    }
}
