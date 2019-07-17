
package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class Report extends DomainEntity {

	// Constructors

	public Report() {
		super();
	}


	// Attributes 

	private Integer				originalityScore;
	private Integer				qualityScore;
	private Integer				readabilityScore;
	private String				decision;
	private Collection<String>	comments;


	@Range(min = 0, max = 10)
	public Integer getOriginalityScore() {
		return this.originalityScore;
	}

	public void setOriginalityScore(final Integer originalityScore) {
		this.originalityScore = originalityScore;
	}

	@Range(min = 0, max = 10)
	public Integer getQualityScore() {
		return this.qualityScore;
	}

	public void setQualityScore(final Integer qualityScore) {
		this.qualityScore = qualityScore;
	}

	@Range(min = 0, max = 10)
	public Integer getReadabilityScore() {
		return this.readabilityScore;
	}

	public void setReadabilityScore(final Integer readabilityScore) {
		this.readabilityScore = readabilityScore;
	}

	@NotBlank
	@Pattern(regexp = "^(BORDER-LINE)|(ACCEPTED)|(REJECTED)$")
	@NotNull
	public String getDecision() {
		return this.decision;
	}

	public void setDecision(final String decision) {
		this.decision = decision;
	}

	@ElementCollection
	public Collection<String> getComments() {
		return this.comments;
	}

	public void setComments(final Collection<String> comments) {
		this.comments = comments;
	}


	// Relationships

	private Reviewer				reviewer;
	private Collection<Submission>	submissions;


	@ManyToOne(optional = false)
	@NotBlank
	@Valid
	public Reviewer getReviewer() {
		return this.reviewer;
	}

	public void setReviewer(final Reviewer reviewer) {
		this.reviewer = reviewer;
	}

	@OneToMany
	@Valid
	public Collection<Submission> getSubmissions() {
		return this.submissions;
	}

	public void setSubmissions(final Collection<Submission> submissions) {
		this.submissions = submissions;
	}

}
