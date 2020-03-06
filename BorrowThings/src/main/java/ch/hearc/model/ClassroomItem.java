package ch.hearc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "ClassroomsItems")
public class ClassroomItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @ManyToOne
    @JoinColumn
    private Classroom classroom;

    @Id
    @ManyToOne
    @JoinColumn
    private Item item;

    @Column
    private Date addDate;

}
