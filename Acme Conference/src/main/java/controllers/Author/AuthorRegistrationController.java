/*
 * HandyWorkerController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import security.UserAccount;
import services.ActorService;
import services.UserAccountService;
import controllers.AbstractController;
import domain.Author;

@Controller
@RequestMapping("/none/author")
public class AuthorRegistrationController extends AbstractController {

	// Constructors

	public AuthorRegistrationController() {
		super();
	}


	// Services

	//	@Autowired
	//	AuthorService		authorService;

	@Autowired
	ActorService		actorService;

	@Autowired
	UserAccountService	userAccountService;


	// Create
	//
	//	@RequestMapping(value = "/create", method = RequestMethod.GET)
	//	public ModelAndView create() {
	//		ModelAndView result;
	//		final AuthorService authorService;
	//
	//		author = this.authorService.create();
	//		result = new ModelAndView("none/author/create");
	//		result.addObject("authorService", authorService);
	//		return result;
	//	}

	//	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	//	public ModelAndView save(@Valid final author handyWorker, final BindingResult binding) {
	//		ModelAndView result;
	//
	//		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
	//		handyWorker.getUserAccount().setPassword(encoder.encodePassword(handyWorker.getUserAccount().getPassword(), null));
	//		if (binding.hasErrors()) {
	//			for (final ObjectError error : binding.getAllErrors())
	//				System.out.println(error.getDefaultMessage());
	//			result = this.createEditModelAndView(handyWorker);
	//			result.addObject("author", handyWorker);
	//			result.addObject("message", "author.commit.error");
	//		} else
	//			try {
	//				final String make = author.getName() + " " + author.getMiddleName() + " " + author.getSurname();
	//				handyWorker.setMake(make);
	//				System.out.println(make);
	//				this.authorService.save(author);
	//				result = new ModelAndView("redirect:/author/display.do");
	//			} catch (final Throwable ops) {
	//
	//				result = new ModelAndView("none/author/create");
	//				result.addObject("author", author);
	//				result.addObject("message", "author.commit.error");
	//			}
	//
	//		return result;
	//
	//	}

	protected ModelAndView createEditModelAndView(final Author author) {
		ModelAndView result;

		result = this.createEditModelAndView(author, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Author author, final String messageCode) {
		final ModelAndView result;
		UserAccount userAccount = new UserAccount();
		userAccount = author.getUserAccount();

		result = new ModelAndView("none/author/create");
		result.addObject("author", author);
		result.addObject("userAccount", userAccount);
		result.addObject("message", messageCode);

		return result;
	}

}
