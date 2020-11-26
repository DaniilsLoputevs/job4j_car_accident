package controllers;

import models.Accident;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
}
