
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;

@Entity
@Access(AccessType.PROPERTY)
public class Reviewer extends Actor {

	// Constructors

	public Reviewer() {
		super();
	}

	// Attributes 

}
