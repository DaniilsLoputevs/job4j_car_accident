package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stores.AccidentMemStore;

@Controller
public class IndexController {
    @Autowired
    private AccidentMemStore accidentMemStore;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentMemStore.getAll());
        return "index";
    }

}