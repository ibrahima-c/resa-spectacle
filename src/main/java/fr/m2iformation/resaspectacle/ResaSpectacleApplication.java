package fr.m2iformation.resaspectacle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.m2iformation.resaspectacle.services.ISpectacleService;

@SpringBootApplication
public class ResaSpectacleApplication implements CommandLineRunner {

    @Autowired
    private ISpectacleService serviceSpectacle;

    public static void main( String[] args ) {
        SpringApplication.run( ResaSpectacleApplication.class, args );
    }

    @Override
    public void run( String... args ) throws Exception {

        // Category category = new Category();
        // category.setTitle( CategoryName.Concert.getName() );
        // serviceSpectacle.addCategory( category );
        // System.out.println( "Id généré = " + category.getId() );
        //
        // serviceSpectacle.removeCategory( category.getId() );
        // System.out.println( "Category supprimé" );

    }
}
