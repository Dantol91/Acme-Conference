
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.SectionRepository;
import domain.Section;
import domain.Tutorial;

@Service
@Transactional
public class SectionService {

	// Repository

	@Autowired
	private SectionRepository	sectionRepository;

	// Services

	@Autowired
	private ServiceUtils		serviceUtils;

	@Autowired
	private TutorialService		tutorialService;


	// CRUD methods

	public Section findOne(final Integer id) {
		this.serviceUtils.checkId(id);
		return this.sectionRepository.findOne(id);
	}

	public Collection<Section> findAll(final Collection<Integer> ids) {
		this.serviceUtils.checkIds(ids);
		return this.sectionRepository.findAll(ids);
	}

	public Collection<Section> findAll() {
		return this.sectionRepository.findAll();
	}

	public Collection<Section> findByTutorial(final Tutorial dependency) {
		this.serviceUtils.checkId(dependency.getId());
		Assert.notNull(this.tutorialService.findOne(dependency.getId()));
		return this.sectionRepository.findByTutorial(dependency.getId());
	}

	public Section create() {
		Section res;
		res = new Section();
		Assert.notNull(res);
		return res;
	}

	public Section save(final Section section) {
		Assert.notNull(section);
		Section res;
		res = this.sectionRepository.save(section);
		return res;
	}

	public void delete(final Section section) {
		Assert.notNull(section);
		this.sectionRepository.delete(section);
	}

	// Other methods

	public void flush() {
		this.sectionRepository.flush();
	}

}
