package fr.m2iformation.resaspectacle.controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.m2iformation.resaspectacle.repos.SpectacleRepository;

@Controller
public class AccueilControllers {

    @Autowired
    private SpectacleRepository spectacleRepository;

    @GetMapping( "/" )
    public String pageAccueil( Model model ) {
        model.addAttribute( "date", LocalDate.now() );

        return "index";
    }

    // @GetMapping("/liste")
    // public String pageListe(Model model) {
    // model.addAttribute("singers", service.allSingers());
    // return "liste";
    // }
    //
    // @GetMapping("/create")
    // public String pageAjouter(@ModelAttribute Singer singer, Model model) {
    // singer = new Singer();
    // model.addAttribute("singer", singer);
    // return "create";
    // }
    //
    // @PostMapping("/create")
    // public String actionAjouter(@Valid @ModelAttribute Singer singer,
    // BindingResult result) {
    // if (result.hasErrors()) {
    // return "create";
    // }
    // service.save(singer);
    // return "redirect:/liste";
    // }
}
