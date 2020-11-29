package controllers;

import models.Accident;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repositories.BasicCrudRep;

@Controller
public class IndexController {
//    @Autowired
//    private AccidentMemRep accidentMemStore;
    @Autowired
    private BasicCrudRep<Accident> accidentHibernate;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("accidents", accidentHibernate.getAll());
        return "index";
    }

}