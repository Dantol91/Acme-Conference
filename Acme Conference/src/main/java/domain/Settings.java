
package domain;

import java.util.Collection;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Settings extends DomainEntity {

	// Constructors

	public Settings() {
		super();
	}


	// Attributes 

	private String				systemName;
	private String				banner;
	private String				welcomeMessageEnglish;
	private String				welcomeMessageSpanish;
	private String				countryCode;
	private Collection<String>	creditCardMakes;
	private List<String>		topicSpanish;
	private List<String>		topicEnglish;
	private List<String>		voidWords;


	@NotBlank
	@NotNull
	public String getSystemName() {
		return this.systemName;
	}

	public void setSystemName(final String systemName) {
		this.systemName = systemName;
	}

	@NotBlank
	@URL
	@NotNull
	public String getBanner() {
		return this.banner;
	}

	public void setBanner(final String banner) {
		this.banner = banner;
	}

	@NotBlank
	@NotNull
	public String getWelcomeMessageEnglish() {
		return this.welcomeMessageEnglish;
	}

	public void setWelcomeMessageEnglish(final String welcomeMessageEnglish) {
		this.welcomeMessageEnglish = welcomeMessageEnglish;
	}

	@NotBlank
	@NotNull
	public String getWelcomeMessageSpanish() {
		return this.welcomeMessageSpanish;
	}

	public void setWelcomeMessageSpanish(final String welcomeMessageSpanish) {
		this.welcomeMessageSpanish = welcomeMessageSpanish;
	}

	@NotBlank
	@Pattern(regexp = "\\+\\d{1,3}")
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(final String countryCode) {
		this.countryCode = countryCode;
	}

	@NotNull
	@ElementCollection
	public Collection<String> getCreditCardMakes() {
		return this.creditCardMakes;
	}

	public void setCreditCardMakes(final Collection<String> creditCardMakes) {
		this.creditCardMakes = creditCardMakes;
	}

	@NotNull
	@ElementCollection
	public List<String> getTopicSpanish() {
		return this.topicSpanish;
	}

	public void setTopicSpanish(final List<String> topicSpanish) {
		this.topicSpanish = topicSpanish;
	}

	@NotNull
	@ElementCollection
	public List<String> getTopicEnglish() {
		return this.topicEnglish;
	}

	public void setTopicEnglish(final List<String> topicEnglish) {
		this.topicEnglish = topicEnglish;
	}

	@NotNull
	@ElementCollection
	public List<String> getVoidWords() {
		return this.voidWords;
	}

	public void setVoidWords(final List<String> voidWords) {
		this.voidWords = voidWords;
	}

}
