package it.uniroma3.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin";
        }
        else if (request.isUserInRole("ROLE_USER")) {
            return "redirect:/user";
        }
        return "redirect:/login";
    }

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	@RequestMapping(value="/user", method = RequestMethod.GET)
	public String common(ModelMap model) {
		return "user";
	}

	@Secured({"ROLE_ADMIN"})
	@RequestMapping(value="/admin", method = RequestMethod.GET)
	public String admin(ModelMap model) {
		return "admin";
	}

	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Ciao " + user.getName() 
			+ ", purtroppo non disponi dei permessi per accedere a questa pagina!");
		} else {
			model.addObject("msg", 
					"Non disponi dei permessi per accedere a questa pagina!");
		}

		model.setViewName("403");
		return model;
	}

	//Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Username o password non corretti!");
		}

		if (logout != null) {
			model.addObject("msg", "Hai eseguito il logout con successo.");
		}
		model.setViewName("login");

		return model;

	}
}
