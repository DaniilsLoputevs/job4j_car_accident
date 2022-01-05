package controllers;

import models.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repositories.AccidentMemRep;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
//    private AccidentRepository accidentRepository;
    private AccidentMemRep accidentRepository;

    @GetMapping("/")
    public String index(Model model) {
//                accidentRepository.findAll().forEach(res::add);
        List<Accident> res = new ArrayList<>(accidentRepository.getAll());
        model.addAttribute("accidents", res);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("accidents", accidentRepository.getAll());
//        model.addAttribute("accidents", accidentRepository.findAll());
        return "index";
    }

}