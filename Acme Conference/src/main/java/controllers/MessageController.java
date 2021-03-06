
package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import domain.Actor;
import domain.Administrator;
import domain.Message;

@Controller
@RequestMapping("message/actor")
public class MessageController extends AbstractController {

	// Services

	//	@Autowired
	//	private MessageService	messageService;

	@Autowired
	private ActorService	actorService;


	// List

	@RequestMapping("list")
	public ModelAndView list(@RequestParam(required = true) final Integer folderId) {
		final ModelAndView res = new ModelAndView("message/list");
		//	final Collection<Message> messages = this.messageService.findByActor(actor);
		//		res.addObject("messages", messages);
		//		System.out.println(messages);
		res.addObject("requestURI", "message/actor/list.do");
		return res;
	}
	//
	//	// Create
	//
	//	@SuppressWarnings("unused")
	//	@RequestMapping("create")
	//	private ModelAndView create(@RequestParam(required = false) final Boolean isBroadcast) {
	//		final Actor principal = this.actorService.findPrincipal();
	//		//		final Message message = this.messageService.create(folder);
	//		Boolean broadcast = false;
	//		if (isBroadcast != null)
	//			broadcast = isBroadcast;
	//		//		final ModelAndView res = this.createEditModelAndView(message, broadcast);
	//		//		return res;
	//	}

	//	// Edit
	//
	//	@SuppressWarnings("unused")
	//	@RequestMapping("edit")
	//	private ModelAndView edit(@RequestParam(required = true) final Integer messageId) {
	//		final Message message = this.messageService.findOne(messageId);
	//		Assert.notNull(message);
	//		final ModelAndView res = this.createEditModelAndView(message, false);
	//		return res;
	//	}
	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "edit", method = RequestMethod.POST, params = "save")
	//	private ModelAndView save(@Valid final Message message, final BindingResult binding) {
	//		ModelAndView res = null;
	//		if (binding.hasErrors())
	//			res = this.createEditModelAndView(message, false);
	//		else
	//			try {
	//				this.messageService.save(message);
	//				res = new ModelAndView("redirect:list.do?folderId=" + String.valueOf(message.getFolder().getId()));
	//			} catch (final Throwable t) {
	//				res = this.createEditModelAndView(message, "cannot.commit.error", false);
	//			}
	//		return res;
	//	}

	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "edit", method = RequestMethod.POST, params = "broadcast")
	//	private ModelAndView broadcast(@Valid final Message message, final BindingResult binding) {
	//		ModelAndView res = null;
	//		if (binding.hasErrors())
	//			res = this.createEditModelAndView(message, true);
	//		else
	//			try {
	//				this.messageService.broadcast(message);
	//				res = new ModelAndView("redirect:list.do?folderId=" + String.valueOf(message.getFolder().getId()));
	//			} catch (final Throwable t) {
	//				res = this.createEditModelAndView(message, "cannot.commit.error", true);
	//			}
	//		return res;
	//	}

	//	// Delete
	//
	//	@SuppressWarnings("unused")
	//	@RequestMapping(value = "edit", method = RequestMethod.POST, params = "delete")
	//	private ModelAndView delete(final Message message, final BindingResult binding) {
	//		ModelAndView res = null;
	//		try {
	//			this.messageService.delete(message);
	//			res = new ModelAndView("redirect:/folder/actor/list.do");
	//		} catch (final Throwable t) {
	//			res = this.createEditModelAndView(message, "cannot.commit.error", false);
	//		}
	//		return res;
	//	}

	// Ancillary methods

	private ModelAndView createEditModelAndView(final Message messageObject, final Boolean isBroadcast) {
		return this.createEditModelAndView(messageObject, null, isBroadcast);
	}

	private ModelAndView createEditModelAndView(final Message messageObject, final String message, Boolean isBroadcast) {
		final ModelAndView res = new ModelAndView("message/edit");
		final Actor principal = this.actorService.findPrincipal();
		res.addObject("messageObject", messageObject);
		res.addObject("message", message);
		res.addObject("actors", this.actorService.findAll());
		if (!(this.actorService.findPrincipal() instanceof Administrator))
			isBroadcast = false;
		res.addObject("isBroadcast", isBroadcast);
		return res;
	}

}
