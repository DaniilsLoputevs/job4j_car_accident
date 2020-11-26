package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        List temp = List.of("accident One", "accident two", "accident three");
        model.addAttribute("accidents", temp);
        return "index";
    }

}