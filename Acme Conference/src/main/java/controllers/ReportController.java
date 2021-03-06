
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import domain.Actor;
import domain.Report;

@Controller
@RequestMapping("report")
public class ReportController extends AbstractController {

	// Services

	//	@Autowired
	//	private ReportService		reportService;

	@Autowired
	private ActorService	actorService;


	// List

	//	@RequestMapping("actor/profile")
	//	public ModelAndView profile(@RequestParam(required = true) final Integer reportId) {
	//		final ModelAndView res = new ModelAndView("report/profile");
	//		//		final Report report = this.reportService.findOne(reportId);
	//		res.addObject("report", report);
	//		res.addObject("requestURI", "report/profile.do");
	//		this.isPrincipalAuthorizedEdit(res, report);
	//		return res;
	//	}

	// Create

	//	@SuppressWarnings("unused")
	//	@RequestMapping("referee/create")
	//	private ModelAndView create(@RequestParam(required = true) final Integer complaintId) {
	//		final Report report = this.reportService.create(complaint);
	//		final ModelAndView res = this.createEditModelAndView(report);
	//		return res;
	//	}

	// Edit

	//	@SuppressWarnings("unused")
	//	@RequestMapping("referee/edit")
	//	private ModelAndView edit(@RequestParam(required = true) final Integer reportId) {
	//		final Report report = this.reportService.findOne(reportId);
	//		Assert.notNull(report);
	//		final ModelAndView res = this.createEditModelAndView(report);
	//		return res;
	//	}

	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "referee/edit", method = RequestMethod.POST, params = "save")
	//	private ModelAndView save(@Valid final Report report, final BindingResult binding) {
	//		ModelAndView res = null;
	//		if (binding.hasErrors())
	//			res = this.createEditModelAndView(report);
	//		else
	//			try {
	//				this.reportService.save(report);
	//				res = new ModelAndView("redirect:/report/actor/profile.do?reportId=" + String.valueOf(report.getId()));
	//			} catch (final Throwable t) {
	//				res = this.createEditModelAndView(report, "cannot.commit.error");
	//			}
	//		return res;
	//	}

	// Delete

	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "referee/edit", method = RequestMethod.POST, params = "delete")
	//	private ModelAndView delete(final Report report, final BindingResult binding) {
	//		ModelAndView res = null;
	//		try {
	//			this.reportService.delete(report);
	//			res = new ModelAndView("redirect:/");
	//		} catch (final Throwable t) {
	//			res = this.createEditModelAndView(report, "cannot.commit.error");
	//		}
	//		return res;
	//	}

	// Others Methods
	//
	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "referee/edit", method = RequestMethod.POST, params = "addAttachment")
	//	private ModelAndView addAttachment(final Report report, final BindingResult binding) {
	//		ModelAndView res = null;
	//		try {
	//			final Url url = new Url();
	//			url.setUrl("");
	//			if (report.getAttachments() == null)
	//				report.setAttachments(new ArrayList<Url>());
	//			report.getAttachments().add(url);
	//			res = this.createEditModelAndView(report);
	//		} catch (final Throwable t) {
	//			res = this.createEditModelAndView(report, "cannot.commit.error");
	//		}
	//		return res;
	//	}
	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "referee/edit", method = RequestMethod.POST, params = "removeAttachment")
	//	private ModelAndView removeAttachment(final Report report, final BindingResult binding) {
	//		ModelAndView res = null;
	//		try {
	//			report.getAttachments().remove(report.getAttachments().size() - 1);
	//			res = this.createEditModelAndView(report);
	//		} catch (final Throwable t) {
	//			res = this.createEditModelAndView(report, "cannot.commit.error");
	//		}
	//		return res;
	//	}

	// Ancillary methods

	private ModelAndView createEditModelAndView(final Report report) {
		return this.createEditModelAndView(report, null);
	}

	private ModelAndView createEditModelAndView(final Report report, final String message) {
		final ModelAndView res = new ModelAndView("report/edit");
		res.addObject("report", report);
		res.addObject("message", message);
		this.isPrincipalAuthorizedEdit(res, report);
		return res;
	}

	private void isPrincipalAuthorizedEdit(final ModelAndView modelAndView, final Report report) {
		Boolean res = false;
		final Actor principal = this.actorService.findPrincipal();
		res = true;
		modelAndView.addObject("isPrincipalAuthorizedEdit", res);
	}

}
