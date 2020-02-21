package ch.hearc;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Person")
public class Person {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Integer id;

	@Column
	private String firstname;
	
	@Column
	private String lastname;
	
//	@Column
//	private Integer role;
	
}
