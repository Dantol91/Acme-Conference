
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.FinderRepository;
import domain.Actor;
import domain.Finder;

@Transactional
@Service
public class FinderService {

	// Managed Repository 

	@Autowired
	private FinderRepository	finderRepository;

	//	Supporting Services

	@Autowired
	private ActorService		actorService;


	// Constructors 

	public FinderService() {
		super();
	}

	// Simple CRUD methods
	public Finder create() {
		Finder res;
		res = new Finder();
		Assert.notNull(res);
		return res;
	}

	public Finder findOne(final int finderId) {
		Finder res;
		res = this.finderRepository.findOne(finderId);
		return res;
	}
	public Collection<Finder> findAll() {
		Collection<Finder> res;
		res = this.finderRepository.findAll();
		return res;
	}
	public Finder save(final Finder finder) {
		Assert.notNull(finder);
		Finder res;
		res = this.finderRepository.save(finder);
		return res;
	}

	public void delete(final Finder finder) {
		Assert.notNull(finder);
		this.finderRepository.delete(finder);
	}

	public Finder findByActorId(final Actor a) {
		Assert.notNull(a);
		Assert.isTrue(a.getId() > 0);
		Assert.notNull(this.actorService.findOne(a.getId()));
		return this.finderRepository.findByActorId(a.getId());
	}
	public Finder findAllByActor(final Actor a) {
		Assert.notNull(a);
		Assert.isTrue(a.getId() > 0);
		return this.finderRepository.findByActorId(a.getId());
	}

}
