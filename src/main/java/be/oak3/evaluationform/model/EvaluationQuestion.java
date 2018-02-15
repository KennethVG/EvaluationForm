package be.oak3.evaluationform.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class  EvaluationQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Score score;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "evaluation_id", nullable = false)
    private Evaluation evaluation;


    public EvaluationQuestion() {
    }


    @Enumerated(EnumType.STRING)
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EvaluationQuestion)) return false;

        EvaluationQuestion that = (EvaluationQuestion) o;

        return getId() == that.getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    @Override
    public String toString() {
        return "EvaluationQuestion{" +
                "id=" + id +
                ", score=" + score +
                ", question=" + question +
                ", evaluation=" + evaluation +
                '}';
    }
}
