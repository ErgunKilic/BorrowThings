package ch.hearc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ch.hearc.model.*;

@Controller
public class RoleController {

	@Autowired 
	RoleRepository roleRepository;
	
	@GetMapping("/role/all")
	public  String getAll(Map<String, Object> model) {
		model.put("roles", roleRepository.findAll());
		return "role/roles";
	}
	
	@GetMapping("/role/create")
	public String roleForm(Model model) {
		model.addAttribute("role", new Role());
		return "role/role-form";
	}
		
	@PostMapping("/role/insert")
	public RedirectView insertRole(@ModelAttribute Role role, Model model) {
		roleRepository.save(role);
		return new RedirectView("/role/all");
	}
}
