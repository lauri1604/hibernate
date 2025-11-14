package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcourse", nullable = false)
    private Integer id;

    @Column(name = "description", nullable = false, length = 100)
    private String description;

    @Temporal(TemporalType.DATE)
    @Column(name = "begindate", nullable = false)
    private LocalDate beginDate = LocalDate.now();

    @Temporal(TemporalType.DATE)
    @Column(name = "enddate", nullable = true)
    private LocalDate endDate;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students = new ArrayList<>();
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Course course) {
            return Objects.equals(id, course.id) && Objects.equals(description, course.description) && Objects.equals(beginDate, course.beginDate) && Objects.equals(endDate, course.endDate);
        }
        return false;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, beginDate, endDate);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
