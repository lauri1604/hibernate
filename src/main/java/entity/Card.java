package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idcard", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Transient
    @Enumerated(EnumType.STRING)
    private type type;

    @OneToOne
    @JoinColumn(name = "idstudent")
    private Student student;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(id, card.id) && Objects.equals(code, card.code) && type == card.type && Objects.equals(student, card.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, type, student);
    }
}
