package ch.hearc.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "classrooms")
@TableGenerator(name = "tab", initialValue = 1)
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "tab")
    @Column
    private Integer id;
    
    @Column
    private String name;

    //@OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //private Set<ClassroomItem> classroomItems = new HashSet<>();

    @OneToMany(mappedBy = "classroom")
    private Set<Item> items;

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
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
}
