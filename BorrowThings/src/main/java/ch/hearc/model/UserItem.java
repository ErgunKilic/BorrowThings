package ch.hearc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "UsersItems")
public class UserItem implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    @Id
    @ManyToOne
    @JoinColumn
    private User user;

    @Id
    @ManyToOne
    @JoinColumn
    private Item item;

    @Column
    private Date borrowDate;
 
}
