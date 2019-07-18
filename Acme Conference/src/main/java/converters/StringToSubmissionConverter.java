
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import repositories.SubmissionRepository;
import domain.Submission;

@Component
@Transactional
public class StringToSubmissionConverter implements Converter<String, Submission> {

	@Autowired
	private SubmissionRepository	repository;


	@Override
	public Submission convert(final String s) {
		Submission res;
		int id;

		try {
			if (StringUtils.isEmpty(s))
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
