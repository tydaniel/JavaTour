package net.tydaniel.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.tydaniel.spring.model.User;
import net.tydaniel.spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("listUsers", this.userService.listUsers());
		return "user";
	}
	
	
	@RequestMapping(value= "/user/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User p){		
		if(p.getId() == 0){
			this.userService.addUser(p);
		}else{
			this.userService.updateUser(p);
		}		
		return "redirect:/viewusers";		
	}
	
	@RequestMapping("/user/remove/{id}")
    public String removePerson(@PathVariable("id") int id){		
        this.userService.removeUser(id);
        return "redirect:/viewusers";
    }
	
	@RequestMapping("/user/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("user", this.userService.getUserById(id));
        model.addAttribute("listUsers", this.userService.listUsers());
        return "user";
    }


}
