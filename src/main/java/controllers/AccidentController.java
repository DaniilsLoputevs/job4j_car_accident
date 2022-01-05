package controllers;

import models.Accident;
import models.AccidentType;
import models.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repositories.AccidentMemRep;
import repositories.RuleMemRep;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class AccidentController {
    private static final Logger LOG = LoggerFactory.getLogger(AccidentController.class);
    private final AccidentMemRep accidentsRep;
//    private final AccidentRepository accidentsRep;
    private final RuleMemRep rulesRep;
//    private final RuleMemRep rulesRep;

    public AccidentController(AccidentMemRep accidentsRep, RuleMemRep rulesRep) {
        this.accidentsRep = accidentsRep;
        this.rulesRep = rulesRep;
    }
//    public AccidentController(AccidentRepository accidentsRep, RuleMemRep rulesRep) {
//        this.accidentsRep = accidentsRep;
//        this.rulesRep = rulesRep;
//    }

    @GetMapping("accidents/create")
    public String create(Model model) {
        List<AccidentType> types = List.of(
                AccidentType.of(1, "Две машины"),
                AccidentType.of(2, "Машина и человек"),
                AccidentType.of(3, "Машина и велосипед")
        );
        model.addAttribute("types", types);

        model.addAttribute("rules", rulesRep.getAll());
        return "accidents/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
//        LOG.info("accident: {}", accident);
        Set<Rule> rules = Stream.of(req.getParameterValues("rulesIds"))
                .map(id -> rulesRep.getBy(Integer.parseInt(id)))
                .collect(Collectors.toSet());
        accident.setRules(rules);
        System.out.println("DEV :: accident = " + accident);
//        accidentsRep.save(accident);
        accidentsRep.add(accident);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") int id, Model model) {
//        model.addAttribute("accident", accidentsRep.findById(id));
        model.addAttribute("accident", accidentsRep.getBy(id));
        return "accidents/update";
    }
}
