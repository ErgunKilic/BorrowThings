package ch.hearc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RoleController {

	@Autowired 
	RoleRepository roleRepository;
	
	@GetMapping("/role/all")
	public  String getAll(Map<String, Object> model) {
		
		model.put("roles", roleRepository.findAll());
		
		return "roles";
	}
	
	@GetMapping("/role/create")
	public String roleForm(Model model) {
		model.addAttribute("role", new Role());
		
		return "role-form";
	}
		
	@PostMapping("/role/insert")
	public String insertRole(@ModelAttribute Role role, Model model) {
			
		roleRepository.save(role);
		
		return "role-form";
		
	}
}
