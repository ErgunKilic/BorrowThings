package ch.hearc.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "items")
@TableGenerator(name = "tab", initialValue = 1)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @Column
    private Integer id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer stock;

    //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Set<UserItem> userItems = new HashSet<>();
    //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Set<ClassroomItem> classroomItems = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;


    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescritpion(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
