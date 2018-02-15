package be.oak3.evaluationform.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String firstName;

    @NotNull
    private String eMail;

    @ManyToMany
    @JoinTable(name = "student_subtopic", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "subtopic_id", referencedColumnName = "id"))
    private Set<Subtopic> studentSubtopics;


    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public Set<Subtopic> getStudentsubtopics() {
        return studentSubtopics;
    }

    public void setStudentsubtopics(Set<Subtopic> studentsubtopics) {
        this.studentSubtopics = studentsubtopics;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", studentsubtopics=" + studentSubtopics +
                '}';
    }
}
