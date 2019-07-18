
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.ConferenceRepository;
import domain.Conference;

@Component
@Transactional
public class StringToConferenceConverter implements Converter<String, Conference> {

	@Autowired
	private ConferenceRepository	repository;


	@Override
	public Conference convert(final String s) {
		Conference res;
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
