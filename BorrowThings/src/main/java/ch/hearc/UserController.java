package ch.hearc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired 
	UserRepository userRepository;
	@Autowired 
	RoleRepository roleRepository;
	
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
		
//		System.out.println(roleId);
//		Role roleTmp = roleRepository.findById().get();
		
//		Role roleTmp = roleRepository.findById(user.getRole().getId()).get();
//		user.setRole(roleRepository.findById(user.getRole().getId()).get());
//		user.setRole(roleTmp);
		userRepository.save(user);
		
		return "user-form";
		
	}


}
