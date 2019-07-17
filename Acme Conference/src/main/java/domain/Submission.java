
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Submission extends DomainEntity {

	// Constructors

	public Submission() {
		super();
	}


	// Attributes 

	private String	ticker;
	private Date	moment;
	private String	status;


	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(final String ticker) {
		this.ticker = ticker;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(final String status) {
		this.status = status;
	}


	// Relationships

	private Author			author;
	private Presentation	presentation;
	private Paper			paper;
	private Paper			paperCameraReady;


	@NotBlank
	@Valid
	@ManyToOne(optional = false)
	public Author getAuthor() {
		return this.author;
	}

	public void setAuthor(final Author author) {
		this.author = author;
	}

	@NotBlank
	@Valid
	@ManyToOne(optional = false)
	public Presentation getPresentation() {
		return this.presentation;
	}

	public void setPresentation(final Presentation presentation) {
		this.presentation = presentation;
	}

	@OneToOne(optional = false)
	@Valid
	public Paper getPaper() {
		return this.paper;
	}

	public void setPaper(final Paper paper) {
		this.paper = paper;
	}

	@OneToOne(optional = true)
	@Valid
	public Paper getPaperCameraReady() {
		return this.paperCameraReady;
	}

	public void setPaperCameraReady(final Paper paperCameraReady) {
		this.paperCameraReady = paperCameraReady;
	}

}
