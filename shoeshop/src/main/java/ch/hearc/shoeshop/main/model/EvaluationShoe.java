package ch.hearc.shoeshop.main.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Model of an evaluation of a shoe
 * @author AlexandreBesia
 *
 */
@Entity
public class EvaluationShoe {
	
	// table fields and table relationship
	@ManyToOne
    @JoinColumn(name="shoe_id", nullable=false)
	private Shoe shoe;
	private Integer note;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public EvaluationShoe() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(shoe, id, note);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaluationShoe other = (EvaluationShoe) obj;
		return Objects.equals(shoe, other.shoe) && Objects.equals(id, other.id) && Objects.equals(note, other.note);
	}

	// getter and setter for table fields
	public Shoe getShoe() {
		return shoe;
	}
	public void setShoe(Shoe shoe) {
		this.shoe = shoe;
	}

	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}
	
	public EvaluationShoe(Integer note) {
		this.note = note;
	}
}
