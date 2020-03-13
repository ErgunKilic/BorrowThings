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
public class ClassroomController {

    @Autowired
    ClassroomRepository classroomRepository;

    @GetMapping("/classroom/all")
    public String getAll(Map<String, Object> model) {
        model.put("classrooms", classroomRepository.findAll());
        return "classrooms";
    }

    @GetMapping("/classroom/create")
    public String roleForm(Model model) {
        model.addAttribute("classrom", new Classroom());
        return "classroom-form";
    }

    @PostMapping("/classroom/insert")
    public String insertRole(@ModelAttribute Classroom classroom, Model model) {
        classroomRepository.save(classroom);
        return "classroom-form";
    }
}
