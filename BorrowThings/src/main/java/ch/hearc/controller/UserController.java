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
	
    @GetMapping("/user/all")
    public String getAll(Map<String, Object> model) {
        model.put("users", userRepository.findAll());
        return "user/users";
	}
	
	@GetMapping("/user/create")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleRepository.findAll());	
		return "user/user-form";
	}
		
	@PostMapping("/user/insert")
	public String insertUser(@ModelAttribute User user, Model model) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return "user/user-form";
	}
}
