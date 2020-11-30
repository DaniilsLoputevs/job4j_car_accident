package controllers;

import models.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repositories.AccidentRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private AccidentRepository accidentRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Accident> res = new ArrayList<>();
        accidentRepository.findAll().forEach(res::add);
        model.addAttribute("accidents", res);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidentRepository.findAll());
        return "index";
    }

}