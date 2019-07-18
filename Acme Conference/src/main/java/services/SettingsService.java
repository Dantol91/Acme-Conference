
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repositories.SettingsRepository;
import security.Authority;
import domain.Settings;

@Service
@Transactional
public class SettingsService {

	// Managed Repository

	@Autowired
	private SettingsRepository	repository;

	//Services

	@Autowired
	private ServiceUtils		serviceUtils;


	// CRUD methods

	public Settings findOne(final Integer id) {
		this.serviceUtils.checkId(id);
		return this.repository.findOne(id);
	}

	public Collection<Settings> findAll(final Collection<Integer> ids) {
		this.serviceUtils.checkIds(ids);
		return this.repository.findAll(ids);
	}

	public Collection<Settings> findAll() {
		return this.repository.findAll();
	}

	public Settings save(final Settings object) {
		this.serviceUtils.checkObject(object);
		this.serviceUtils.checkAuthority(Authority.ADMIN);
		final Settings res = this.repository.save(object);
		return res;
	}

	// Other methods

	public Settings findSettings() {
		return this.repository.findSettings();
	}

	public void flush() {
		this.repository.flush();
	}

}
