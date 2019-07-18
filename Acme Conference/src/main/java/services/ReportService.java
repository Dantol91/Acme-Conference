
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ReportRepository;
import domain.Report;

@Service
@Transactional
public class ReportService {

	// Repository

	@Autowired
	private ReportRepository	reportRepository;

	// Services

	@Autowired
	private ServiceUtils		serviceUtils;

	@Autowired
	private SumissionService	submissionService;


	// CRUD methods

	public Report findOne(final Integer id) {
		this.serviceUtils.checkId(id);
		return this.reportRepository.findOne(id);
	}

	public Collection<Report> findAll(final Collection<Integer> ids) {
		this.serviceUtils.checkIds(ids);
		return this.reportRepository.findAll(ids);
	}

	public Collection<Report> findAll() {
		return this.reportRepository.findAll();
	}

	public Report create() {
		Report res;
		res = new Report();
		Assert.notNull(res);
		return res;
	}

	public Report save(final Report report) {
		Assert.notNull(report);
		Report res;
		res = this.reportRepository.save(report);
		return res;
	}

	public void delete(final Report report) {
		Assert.notNull(report);
		this.reportRepository.delete(report);
	}

	// Other methods

	public void flush() {
		this.reportRepository.flush();
	}

}
