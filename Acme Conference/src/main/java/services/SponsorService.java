
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.SponsorRepository;
import security.Authority;
import security.UserAccount;
import domain.Sponsor;

@Service
@Transactional
public class SponsorService {

	//Managed Repository

	@Autowired
	private SponsorRepository	sponsorRepository;

	// Supporting Service

	@Autowired
	private UserAccountService	userAccountService;

	@Autowired
	private ServiceUtils		serviceUtils;


	// Simple CRUD methods

	public Sponsor create() {
		Sponsor e;
		e = new Sponsor();
		e.setUserAccount(new UserAccount());
		final Authority authority = new Authority();
		authority.setAuthority(Authority.SPONSOR);
		e.getUserAccount().addAuthority(authority);

		return e;
	}

	public Collection<Sponsor> findAll() {
		return this.sponsorRepository.findAll();
	}

	public Sponsor findOne(final int sponsorId) {
		return this.sponsorRepository.findOne(sponsorId);
	}

	public Sponsor save(final Sponsor sponsor) {

		//comprobamos que el sponsor que nos pasan no sea nulo
		Assert.notNull(sponsor);
		Boolean isCreating = null;

		if (sponsor.getId() == 0)
			isCreating = true;
		else {
			isCreating = false;
			//comprobamos que su id no sea negativa por motivos de seguridad
			this.serviceUtils.checkIdSave(sponsor);

			//este sponsor será el que está en la base de datos para usarlo si estamos ante un sponsor que ya existe
			Sponsor sponsorBD;
			Assert.isTrue(sponsor.getId() > 0);

			//cogemos el sponsor de la base de datos
			sponsorBD = this.sponsorRepository.findOne(sponsor.getId());

			//Si el sponsor que estamos guardando es nuevo (no está en la base de datos) le ponemos todos sus atributos vacíos

			sponsor.setUserAccount(sponsorBD.getUserAccount());

			//Comprobamos que el actor sea un Sponsor
			this.serviceUtils.checkAuthority("SPONSOR");
			//esto es para ver si el actor que está logueado es el mismo que se está editando
			this.serviceUtils.checkActor(sponsor);

		}
		Sponsor res;
		//le meto al resultado final el sponsor que he ido modificando anteriormente
		res = this.sponsorRepository.save(sponsor);
		this.flush();

		return res;
	}

	public Sponsor findSponsorById(final int id) {
		return this.sponsorRepository.findSponsorById(id);
	}

	public void flush() {
		this.sponsorRepository.flush();
	}

}
