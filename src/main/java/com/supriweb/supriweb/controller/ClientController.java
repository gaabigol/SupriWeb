package com.supriweb.supriweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.supriweb.supriweb.bo.ClientBO;
import com.supriweb.supriweb.model.Client;

@Controller
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	ClientBO clientBO;

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(ModelMap model) {
		model.addAttribute("client", new Client());
		return new ModelAndView("/client/form", model);

	}
}
