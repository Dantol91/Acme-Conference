
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;
import domain.Actor;

@Service
@Transactional
public class ActorService {

	//Repositories

	@Autowired
	private ActorRepository			actorRepository;

	//Services

	@Autowired
	private SettingsService			settingsService;

	@Autowired
	private AdministratorService	adminService;

	@Autowired
	private SponsorService			sponsorService;


	//	@Autowired
	//	private MessageService			messageService;

	// CRUD methods

	public Actor findOne(final int actorId) {
		Actor res;
		res = this.actorRepository.findOne(actorId);
		return res;
	}

	public Collection<Actor> findAll() {
		Collection<Actor> result;
		result = this.actorRepository.findAll();
		Assert.notNull(result);

		return result;
	}

	public Collection<Actor> findAllExceptMe(final Actor a) {
		Collection<Actor> result;
		result = this.actorRepository.findAll();
		result.remove(a);
		Assert.notNull(result);

		return result;
	}

	// Other methods

	public Actor findOneByUserAccount(final UserAccount userAccount) {
		return this.actorRepository.findOneByUserAccount(userAccount.getId());
	}

	public Actor findPrincipal() {
		final UserAccount userAccount = LoginService.getPrincipal();
		return this.actorRepository.findOneByUserAccount(userAccount.getId());
	}

}
