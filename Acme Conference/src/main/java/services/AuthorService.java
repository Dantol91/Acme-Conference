
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.AuthorRepository;
import security.Authority;
import security.UserAccount;
import domain.Author;

@Service
@Transactional
public class AuthorService {

	//Managed Repository

	@Autowired
	private AuthorRepository	authorRepository;

	// Supporting Service

	@Autowired
	private UserAccountService	userAccountService;

	@Autowired
	private ServiceUtils		serviceUtils;


	// Simple CRUD methods

	public Author create() {
		Author e;
		e = new Author();
		e.setUserAccount(new UserAccount());
		final Authority authority = new Authority();
		authority.setAuthority(Authority.AUTHOR);
		e.getUserAccount().addAuthority(authority);

		return e;
	}

	public Collection<Author> findAll() {
		return this.authorRepository.findAll();
	}

	public Author findOne(final int AuthorId) {
		return this.authorRepository.findOne(AuthorId);
	}

	public Author save(final Author author) {

		//comprobamos que el Author que nos pasan no sea nulo
		Assert.notNull(author);
		Boolean isCreating = null;

		if (author.getId() == 0)
			isCreating = true;
		else {
			isCreating = false;
			//comprobamos que su id no sea negativa por motivos de seguridad
			this.serviceUtils.checkIdSave(author);

			//este Author será el que está en la base de datos para usarlo si estamos ante un Author que ya existe
			Author AuthorBD;
			Assert.isTrue(author.getId() > 0);

			//cogemos el Author de la base de datos
			AuthorBD = this.authorRepository.findOne(author.getId());

			//Si el Author que estamos guardando es nuevo (no está en la base de datos) le ponemos todos sus atributos vacíos

			author.setUserAccount(AuthorBD.getUserAccount());

			//Comprobamos que el actor sea un Author
			this.serviceUtils.checkAuthority("AUTHOR");
			//esto es para ver si el actor que está logueado es el mismo que se está editando
			this.serviceUtils.checkActor(author);

		}
		Author res;
		//le meto al resultado final el Author que he ido modificando anteriormente
		res = this.authorRepository.save(author);
		this.flush();

		return res;
	}

	public Author findAuthorById(final int id) {
		return this.authorRepository.findAuthorById(id);
	}

	public void flush() {
		this.authorRepository.flush();
	}

}
