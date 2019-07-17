
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Student
 * 
 */
@Entity
@Access(AccessType.PROPERTY)
public class Finder extends DomainEntity {

	// Constructors

	public Finder() {
		super();
	}


	// Attributes 

	private String	keyword;
	private String	acronym;
	private String	venue;
	private String	summary;
	private Double	maxFee;
	private Date	start;
	private Date	end;


	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(final String keyword) {
		this.keyword = keyword;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getStart() {
		return this.start;
	}

	public void setStart(final Date start) {
		this.start = start;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getEnd() {
		return this.end;
	}

	public void setEnd(final Date end) {
		this.end = end;
	}

	public String getAcronym() {
		return this.acronym;
	}

	public void setAcronym(final String acronym) {
		this.acronym = acronym;
	}

	public String getVenue() {
		return this.venue;
	}

	public void setVenue(final String venue) {
		this.venue = venue;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(final String summary) {
		this.summary = summary;
	}

	@Min(value = 0)
	public Double getMaxFee() {
		return this.maxFee;
	}

	public void setMaxFee(final Double maxFee) {
		this.maxFee = maxFee;
	}


	// Relationships

	private Collection<Conference>	conferences;
	private Category				category;
	private Actor					actor;


	@Valid
	@ManyToOne(optional = true)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	@Valid
	@ManyToMany
	public Collection<Conference> getConference() {
		return this.conferences;
	}

	public void setConference(final Collection<Conference> conferences) {
		this.conferences = conferences;

	}

	@NotNull
	@Valid
	@OneToOne(optional = false)
	public Actor getActor() {
		return this.actor;
	}

	public void setActor(final Actor actor) {
		this.actor = actor;
	}

}
