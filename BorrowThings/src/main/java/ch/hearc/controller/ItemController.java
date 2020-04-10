package ch.hearc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import ch.hearc.model.*;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ClassroomRepository classroomRepository;

    @GetMapping("/item/all")
    public String getAll(Map<String, Object> model) {
        model.put("items", itemRepository.findAll());
        return "item/items";
    }

    @GetMapping("/item/create")
    public String itemForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("classrooms", classroomRepository.findAll());

        return "item/item-form";
    }

    @PostMapping("/item/insert")
    public String insertItem(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);
        return "item/item-form";
    }

    @GetMapping("/item/{id}")
    public String usersAll(Model model, @PathVariable(value = "id") int id) {
        Classroom classroom = classroomRepository.findById(id).get();
        model.addAttribute("classroom", classroom);
        return "classroom/classroom-update";
    }

    @PostMapping("/item/update")
    public RedirectView userUpdate(@ModelAttribute Item item, Model model) {
        Item itemChange = itemRepository.findById(item.getId()).get();
        itemChange.setName(item.getName());
        itemChange.setDescritpion(item.getDescription());
        itemChange.setStock(item.getStock());

        itemRepository.save(itemChange);
        return new RedirectView("/item/all");
    }
}
