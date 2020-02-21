package ch.hearc;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class PersonController {
	
	@Autowired 
	PersonRepository personRepository;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("person", new Person());
		
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
	public String personForm(Model model) {
		model.addAttribute("person", new Person());
		
		return "person-form";
	}
		
	@PostMapping("/insert")
	public String insertPerson(@ModelAttribute Person person, Model model) {
			
		personRepository.save(person);
		
		return "person-form";
		
	}


}
