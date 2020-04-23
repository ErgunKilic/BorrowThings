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
public class UserItemController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserItemRepository userItemRepository;

    // Emprunt

    @GetMapping("/userItem/all")
    public String getAll(Map<String, Object> model) {
        model.put("usersItems", userItemRepository.findAll());
        return "userItem/usersItems";
    }

    @GetMapping("/userItem/create")
    public String userBorrowForm(Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("roles", roleRepository.findAll());

        return "userItem/userItem-form";
    }

    @PostMapping("/userItem/insert")
    public RedirectView userBorrowInsert(@ModelAttribute UserItem userItem, Model model) {

        return new RedirectView("/userItem/all");
    }

}
