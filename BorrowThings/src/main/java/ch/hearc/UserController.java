package ch.hearc;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.stereotype.Controller;

@Controller
public class UserController {
	
	@Autowired 
	UserRepository personRepository;
	
	@GetMapping("/")
	public String index(final Model model) {
		model.addAttribute("person", new User());
		
		return "index";
	}
	
//	@GetMapping("/all")
//	public  String getAll(Map<String, Object> model) {
//		
//		model.put("persons", personRepository.findAll());
//		
//		return "liste";
//	}
//			
	@GetMapping("/form")
	public String personForm(final Model model) {
		model.addAttribute("person", new User());
		
		return "person-form";
	}
		
	@PostMapping("/insert")
	public String insertPerson(@ModelAttribute final User person, final Model model) {
			
		personRepository.save(person);
		
		return "person-form";
		
	}


}
