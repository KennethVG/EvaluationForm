package be.oak3.evaluationform.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
public class Subtopic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    @NotNull
    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "studentSubtopics")
    private Set<Student> students;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    public Subtopic() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtopic)) return false;

        Subtopic subtopic = (Subtopic) o;

        return getId() == subtopic.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "Subtopic{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", students=" + students +
                ", topic=" + topic +
                '}';
    }
}

