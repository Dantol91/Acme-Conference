
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import domain.Actor;

@Controller
@RequestMapping("/actor")
public class ActorController extends AbstractController {

	// Services 

	@Autowired
	private ActorService	actorService;


	protected ModelAndView createEditModelAndView2(final Actor admin) {
		ModelAndView result;

		result = this.createEditModelAndView2(admin, null);

		return result;
	}

	protected ModelAndView createEditModelAndView2(final Actor admin, final String messageCode) {
		final ModelAndView result;

		final Collection<Actor> allExceptMe = this.actorService.findAllExceptMe(admin);
		result = new ModelAndView("actor/list");
		result.addObject("administrator", admin);
		result.addObject("actors", allExceptMe);
		result.addObject("message", messageCode);

		return result;
	}
}
