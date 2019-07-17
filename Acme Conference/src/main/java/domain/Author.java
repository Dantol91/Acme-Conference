
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
@Access(AccessType.PROPERTY)
public class Author extends Actor {

	// Constructors

	public Author() {
		super();
	}


	// Attributes 

	@Min(0)
	private Double	score;


	public Double getScore() {
		return this.score;
	}

	public void setScore(final Double score) {
		this.score = score;
	}

}
