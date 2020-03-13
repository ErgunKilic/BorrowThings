package ch.hearc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ch.hearc.model.*;

@Controller
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("user", new User());
//		
//		return "index";
//	}
	
	@GetMapping("/user/all")
	public  String getUsers(Map<String, Object> model) {
		
		model.put("users", userRepository.findAll());
		
		return "users";
	}
		
	@GetMapping("/user/create")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleRepository.findAll());
		return "user-form";
	}
		
	@PostMapping("/user/insert")
	public String insertUser(@ModelAttribute User user, Model model) {	
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return "user-form";
		
	}


}
