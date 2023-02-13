package com.avoris.challenge.models;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public final class Student {

    private final String name;
    private final Integer age;
    private final LocalDate endDate;
    private List<Subject> subjects;

    public Student(String name, int age, LocalDate endDate, List<Subject> subjects) {
        this.name = name;
        this.age = age;
        this.endDate = endDate;
        this.subjects = List.copyOf(subjects);
        this.subjects = subjects.stream().map(p -> new Subject(p.getName(), p.getGrade()))
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEndDate() {
        return this.endDate.getDayOfMonth() + "/" + this.endDate.getMonth().getValue();
    }

    public List<Subject> getSubjects() {
        return subjects.stream().map(p -> new Subject(p.getName(), p.getGrade())).collect(Collectors.toList());
    }
}
