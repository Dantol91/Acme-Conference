
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.ReviewerRepository;
import security.Authority;
import security.UserAccount;
import domain.Reviewer;

@Service
@Transactional
public class ReviewerService {

	//Managed Repository

	@Autowired
	private ReviewerRepository	reviewerRepository;

	// Supporting Service

	@Autowired
	private UserAccountService	userAccountService;

	@Autowired
	private ServiceUtils		serviceUtils;


	// Simple CRUD methods

	public Reviewer create() {
		Reviewer e;
		e = new Reviewer();
		e.setUserAccount(new UserAccount());
		final Authority authority = new Authority();
		authority.setAuthority(Authority.REVIEWER);
		e.getUserAccount().addAuthority(authority);

		return e;
	}

	public Collection<Reviewer> findAll() {
		return this.reviewerRepository.findAll();
	}

	public Reviewer findOne(final int ReviewerId) {
		return this.reviewerRepository.findOne(ReviewerId);
	}

	public Reviewer save(final Reviewer reviewer) {

		//comprobamos que el Reviewer que nos pasan no sea nulo
		Assert.notNull(reviewer);
		Boolean isCreating = null;

		if (reviewer.getId() == 0)
			isCreating = true;
		else {
			isCreating = false;
			//comprobamos que su id no sea negativa por motivos de seguridad
			this.serviceUtils.checkIdSave(reviewer);

			//este Reviewer será el que está en la base de datos para usarlo si estamos ante un Reviewer que ya existe
			Reviewer ReviewerBD;
			Assert.isTrue(reviewer.getId() > 0);

			//cogemos el Reviewer de la base de datos
			ReviewerBD = this.reviewerRepository.findOne(reviewer.getId());

			//Si el Reviewer que estamos guardando es nuevo (no está en la base de datos) le ponemos todos sus atributos vacíos

			reviewer.setUserAccount(ReviewerBD.getUserAccount());

			//Comprobamos que el actor sea un Reviewer
			this.serviceUtils.checkAuthority("REVIEWER");
			//esto es para ver si el actor que está logueado es el mismo que se está editando
			this.serviceUtils.checkActor(reviewer);

		}
		Reviewer res;
		//le meto al resultado final el Reviewer que he ido modificando anteriormente
		res = this.reviewerRepository.save(reviewer);
		this.flush();

		return res;
	}

	public Reviewer findReviewerById(final int id) {
		return this.reviewerRepository.findReviewerById(id);
	}

	public void flush() {
		this.reviewerRepository.flush();
	}

}
