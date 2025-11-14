package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "idstudent", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "identification", nullable = false, unique = true)
    private String dni;

    @Column(name = "phone")
    private String phone;

    @ManyToMany
    @JoinTable(name = "student_course",
    joinColumns = @JoinColumn(name = "idcourse"),
    inverseJoinColumns = @JoinColumn(name = "idstudent"))
    private List<Course> courses = new ArrayList<>();

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Card card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student student) {
            return this.id.equals(student.id) && this.dni.equals(student.dni);
        }
        return false;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
