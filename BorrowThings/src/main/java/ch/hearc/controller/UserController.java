package ch.hearc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import ch.hearc.model.*;

@Controller
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/register")
	public String userForm(Model model) {
		User user = new User();
		user.setEnabled(true);
		user.setRole(roleRepository.findById(3).get());
		model.addAttribute("user", user);
		model.addAttribute("roles", roleRepository.findAll());	
		return "register";
	}
	
    @GetMapping("/user/all")
    public String usersAll(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        model.put("userForm", new User());
        return "user/user-list";
	}
	
    @GetMapping("/user/{id}")
    public String usersAll(Model model, @PathVariable(value="id") int id) {
    	User user = userRepository.findById(id).get();
    	model.addAttribute("user", user);
		model.addAttribute("roles", roleRepository.findAll());
        return "user/user-update";
	}
		
	@PostMapping("/user/insert")
	public String userInsert(@ModelAttribute User user, Model model) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "register";
	}
	
	@PostMapping("/user/update")
	public RedirectView userUpdate(@ModelAttribute User user, Model model) {
		User userChange = userRepository.findById(user.getId()).get();
		userChange.setEnabled(user.getEnabled());
		userChange.setRole(user.getRole());
		userRepository.save(userChange);
		return new RedirectView("/user/all");
	}
}
