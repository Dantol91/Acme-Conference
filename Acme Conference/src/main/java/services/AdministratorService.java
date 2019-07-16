
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AdministratorRepository;
import domain.Administrator;

@Service
@Transactional
public class AdministratorService {

	// Managed repository 

	@Autowired
	private AdministratorRepository	administratorRepository;

	//Supporting Services

	@Autowired
	private ServiceUtils			serviceUtils;

	@Autowired
	private UserAccountService		userAccountService;

	@Autowired
	private ActorService			actorService;


	//Constructor

	public AdministratorService() {
		super();
	}

	// CRUD methods

	public Administrator create() {
		Administrator result;
		result = new Administrator();
		result.setUserAccount(this.userAccountService.create("ADMIN"));

		return result;

	}

	public Administrator save(final Administrator administrator) {

		Assert.notNull(administrator);
		final Boolean isCreating = null;

		this.serviceUtils.checkIdSave(administrator);

		Administrator adminDB;
		Assert.isTrue(administrator.getId() > 0);

		adminDB = this.administratorRepository.findOne(administrator.getId());

		administrator.setUserAccount(adminDB.getUserAccount());

		this.serviceUtils.checkAuthority("ADMIN");

		this.serviceUtils.checkActor(administrator);

		Administrator res;

		res = this.administratorRepository.save(administrator);
		return res;
	}

	public Administrator findOne(final int administratorId) {
		return this.administratorRepository.findOne(administratorId);
	}

	public Collection<Administrator> findAll() {
		Collection<Administrator> res;
		res = this.administratorRepository.findAll();
		Assert.notNull(res);

		return res;
	}

	// other business methods 

	public void flush() {
		this.administratorRepository.flush();
	}

}
