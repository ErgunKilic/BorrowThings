package ch.hearc;

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
	
//	@GetMapping("/")
//	public String index(Model model) {
//		model.addAttribute("user", new User());
//		
//		return "index";
//	}
	
//	@GetMapping("/all")
//	public  String getAll(Map<String, Object> model) {
//		
//		model.put("persons", personRepository.findAll());
//		
//		return "liste";
//	}
//			
	@GetMapping("/user/create")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		
		return "user-form";
	}
		
	@PostMapping("/user/insert")
	public String insertUser(@ModelAttribute User user, Model model) {
			
		userRepository.save(user);
		
		return "user-form";
		
	}


}
