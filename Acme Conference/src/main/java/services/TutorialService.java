
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.TutorialRepository;
import domain.Tutorial;

@Service
@Transactional
public class TutorialService {

	//Managed Repository

	@Autowired
	private TutorialRepository	tutorialRepository;

	// Supporting Service

	@Autowired
	private ServiceUtils		serviceUtils;


	// Simple CRUD methods

	public Tutorial create() {
		final Tutorial s = new Tutorial();
		return s;
	}

	public Collection<Tutorial> findAll() {
		return this.tutorialRepository.findAll();
	}

	public Tutorial findOne(final int tutorialId) {
		return this.tutorialRepository.findOne(tutorialId);
	}

	public Tutorial save(final Tutorial s) {
		Assert.notNull(s);
		return this.tutorialRepository.save(s);
	}

	public void delete(final Tutorial s) {
		Assert.notNull(s);
		this.tutorialRepository.delete(s);
	}

}
