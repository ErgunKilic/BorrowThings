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
    //@RequestMapping(value = "/item/all", method = RequestMethod.GET)
    //public String listItems(
        model.put("items", itemRepository.findAll());
        /*
        Model model, 
        @RequestParam("page") Optional<Integer> page, 
        @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(1);
 
        Page<Item> itemPage = itemService.findPaginated(PageRequest.of(currentPage - 1, pageSize));
 
        model.addAttribute("itemPage", itemPage);
 
        int totalPages = itemPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }*/

        return "item/items";
    }

    @GetMapping("/item/create")
    public String itemForm(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("classrooms", classroomRepository.findAll());

        return "item/item-form";
    }

    @PostMapping("/item/insert")
    public RedirectView insertItem(@ModelAttribute Item item, Model model) {
        itemRepository.save(item);
        return new RedirectView("/item/all");
    }

    /*@PostMapping("/classroom/{classroomId}/items")
    public RedirectView createItem(@PathVariable(value = "classroomId") Integer classroomId, @Valid @RequestBody Item item) {
        classroomRepository.findById(classroomId).map(classroom -> {
            item.setClassroom(classroom);
            return itemRepository.save(item);
        }).orElseThrow(() -> new ResourceNotFoundException("ClassroomId " + classroomId + " not found"));
        return new RedirectView("/item/all");
    }*/

    //update 

    @GetMapping("/item/{id}")
    public String itemGet(Model model, @PathVariable(value = "id") int id) {
        Item item = itemRepository.findById(id).get();
        model.addAttribute("item", item);
        return "item/item-update";
    }

    @PostMapping("/item/update")
    public RedirectView userUpdate(@ModelAttribute Item item, Model model) {
        Item itemChange = itemRepository.findById(item.getId()).get();
        itemChange.setName(item.getName());
        itemChange.setDescritpion(item.getDescription());
        itemChange.setStock(item.getStock());
        itemChange.setClassroom(item.getClassroom());
        itemRepository.save(itemChange);
        return new RedirectView("/item/all");
    }


    // Delete 
    @PostMapping("/item/delete/{id}")
    public RedirectView itemDelete(Model model, @PathVariable(value = "id") int id) {
        itemRepository.deleteById(id);
        return new RedirectView("/item/all");
    }
}
