package fr.m2iformation.resaspectacle.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.m2iformation.resaspectacle.models.spectacles.Category;
import fr.m2iformation.resaspectacle.models.spectacles.Session;
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;
import fr.m2iformation.resaspectacle.services.ISpectacleService;

@Controller
public class AccueilControllers {

    @Autowired
    private ISpectacleService serviceSpectacle;

    @GetMapping( "/" )
    public String pageAccueil1( Model model ) {
        model.addAttribute( "date", LocalDate.now() );
        return "index";
    }

    @GetMapping( "/accueil" )
    public String pageAccueil2( Model model ) {
        model.addAttribute( "date", LocalDate.now() );
        return "index";
    }

    @GetMapping( "/listeDesSpectacles" )
    public String pageListe( Model model ) {
        List<Category> categories = serviceSpectacle.allCategories();
        List<Spectacle> allSpectacles = new ArrayList<Spectacle>();
        List<Spectacle> spectaclesParCategorie;
        for ( Category category : categories ) {
            spectaclesParCategorie = (List<Spectacle>) serviceSpectacle.findSpectaclesByCategory( category.getId() );
            if ( spectaclesParCategorie != null )
                allSpectacles.addAll( spectaclesParCategorie );
        }
        model.addAttribute( "spectacles", allSpectacles );
        model.addAttribute( "categories", categories );
        return "listeDesSpectacles";
    }

    @PostMapping( "/affinerListe" )
    public String pageListeAffinee( Model model, @RequestParam( name = "categoryTitle" ) String title,
            @RequestParam( name = "date" ) String dateInString ) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = formatter.parse( dateInString );

        System.out.println( date );
        System.out.println( title );

        return "listeDesSpectacles";
    }

    @GetMapping( "/sessions" )
    public String pageSessions( Model model, @RequestParam( name = "id" ) Integer id ) {
        System.out.println( id );
        List<Session> sessions = serviceSpectacle.findSessionsOfSpectacle( id );
        model.addAttribute( "sessions", sessions );
        System.out.println( sessions );
        return "sessions";
    }
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
