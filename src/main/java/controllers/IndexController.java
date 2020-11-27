package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repositories.AccidentJdbcTemplate;

@Controller
public class IndexController {
//    @Autowired
//    private AccidentMemRep accidentMemStore;
    @Autowired
    private AccidentJdbcTemplate accidentJdbcTemplate;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentJdbcTemplate.getAll());
        return "index";
    }

}