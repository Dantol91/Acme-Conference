
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Registration extends DomainEntity {

	// Constructors

	public Registration() {
		super();
	}


	// Attributes 

	private CreditCard	creditCard;


	@NotNull
	@Valid
	@Column(unique = true)
	public CreditCard getCreditCard() {
		return this.creditCard;
	}

	public void setCreditCard(final CreditCard creditCard) {
		this.creditCard = creditCard;
	}


	// Relationships

	private Author		author;

	@NotBlank
	@Valid
	// Relationships
	private Tutorial	tutorial;


	@NotNull
	@ManyToOne(optional = false)
	public Tutorial getTutorial() {
		return this.tutorial;
	}

	public void setTutorial(final Tutorial tutorial) {
		this.tutorial = tutorial;
	}
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(final Author author) {
		this.author = author;
	}

}
