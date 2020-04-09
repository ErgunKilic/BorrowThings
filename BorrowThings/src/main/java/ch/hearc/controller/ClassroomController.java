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
public class ClassroomController {

    @Autowired
    ClassroomRepository classroomRepository;

    // GET ALL
    @GetMapping("/classroom/all")
    public String getAll(Map<String, Object> model) {
        model.put("classrooms", classroomRepository.findAll());
        return "classroom/classrooms";
    }

    // CREATE
    @GetMapping("/classroom/create")
    public String classroomForm(Model model) {
        model.addAttribute("classroom", new Classroom());
        return "classroom/classroom-form";
    }

    @PostMapping("/classroom/insert")
    public String insertClassroom(@ModelAttribute Classroom classroom, Model model) {
        classroomRepository.save(classroom);
        return "classroom/classroom-form";
    }


    // Update

    @GetMapping("/classroom/{id}")
    public String usersAll(Model model, @PathVariable(value = "id") int id) {
        Classroom classroom = classroomRepository.findById(id).get();
        model.addAttribute("classroom", classroom);
        return "classroom/classroom-update";
    }

    @PostMapping("/classroom/update")
    public RedirectView userUpdate(@ModelAttribute Classroom classroom, Model model) {
        Classroom classroomChange = classroomRepository.findById(classroom.getId()).get();
        classroomChange.setName(classroom.getName());
        classroomRepository.save(classroomChange);
        return new RedirectView("/classroom/all");
    }
}
