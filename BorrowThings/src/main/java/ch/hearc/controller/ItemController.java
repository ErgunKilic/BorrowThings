package ch.hearc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ch.hearc.model.*;

@Controller
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping("/item/all")
    public String getAll(Map<String, Object> model) {
        model.put("items", itemRepository.findAll());
        return "item/items";
    }

    @GetMapping("/item/create")
    public String roleForm(Model model) {
        model.addAttribute("item", new Item());
        return "item/item-form";
    }

    @PostMapping("/item/insert")
    public String insertRole(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);
        return "item/item-form";
    }
}
