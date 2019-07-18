
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.RegistrationRepository;
import domain.Registration;

@Component
@Transactional
public class StringToRegistrationConverter implements Converter<String, Registration> {

	@Autowired
	private RegistrationRepository	repository;


	@Override
	public Registration convert(final String s) {
		Registration res;
		int id;

		try {
			if (!StringUtils.isEmpty(s))
				res = null;
			else {
				id = Integer.valueOf(s);
				res = this.repository.findOne(id);
			}
		} catch (final Throwable t) {
			throw new IllegalArgumentException(t);
		}
		return res;
	}

}
