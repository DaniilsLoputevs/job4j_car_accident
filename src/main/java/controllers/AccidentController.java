package controllers;

import models.Accident;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repositories.AccidentMemStore;

@Controller
public class AccidentController {
    private final AccidentMemStore accidents;

    public AccidentController(AccidentMemStore accidents) {
        this.accidents = accidents;
    }

    @GetMapping("accidents/create")
    public String create() {
        return "accidents/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident) {
        accidents.add(accident);
        System.out.println("LOG: " + accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
        model.addAttribute("accident", accidents.getBy(id));
        return "accidents/update";
    }
}
