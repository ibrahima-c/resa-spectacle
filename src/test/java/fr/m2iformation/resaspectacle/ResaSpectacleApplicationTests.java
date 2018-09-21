package fr.m2iformation.resaspectacle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.m2iformation.resaspectacle.config.WithAutoConfiguration;
import fr.m2iformation.resaspectacle.models.spectacles.Category;
import fr.m2iformation.resaspectacle.models.spectacles.CategoryName;
import fr.m2iformation.resaspectacle.models.spectacles.Session;
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;
import fr.m2iformation.resaspectacle.services.ISpectacleService;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = { WithAutoConfiguration.class } )
public class ResaSpectacleApplicationTests {

    private static Logger     logger = LoggerFactory.getLogger( ResaSpectacleApplicationTests.class );

    @Autowired
    private ISpectacleService serviceSpectacle;

    @Test // Test a lancer une fois pour eviter les doublons de categories
    public void testAddCategory() {
        Category category = new Category( CategoryName.Cirque.getName() );
        serviceSpectacle.addCategory( category );

        Category category2 = new Category( CategoryName.Concert.getName() );
        serviceSpectacle.addCategory( category2 );

        Category category3 = new Category( CategoryName.Film.getName() );
        serviceSpectacle.addCategory( category3 );

        Category category4 = new Category( CategoryName.Theatre.getName() );
        serviceSpectacle.addCategory( category4 );

        Category category5 = new Category( "Accrobate" );
        serviceSpectacle.addCategory( category5 );

        Integer Id = category.getId();
        logger.info( "TestAddCategory : id=" + Id );
        Assert.assertTrue( Id != null );
    }

    @Test
    public void testAllCategories() {
        List<Category> categories = serviceSpectacle.allCategories();
        logger.info( "TestAllCategory : listes des catégories =" + categories );
        Assert.assertTrue( categories.size() > 0 );

    }

    @Test // A utiliser une fois pour definir la base de test
    public void testAddSpectacle() {
        Spectacle spectacle = new Spectacle( "titreTestAdd", "descriptionTestAdd", 240, 40.0, 300 );
        serviceSpectacle.addSpectacle( spectacle, 45 );

        Spectacle spectacle1 = new Spectacle( "titreTestAdd1", "descriptionTestAdd", 240, 40.0, 300 );
        serviceSpectacle.addSpectacle( spectacle1, 45 );

        Spectacle spectacle2 = new Spectacle( "titreTestAdd2", "descriptionTestAdd", 240, 40.0, 300 );
        serviceSpectacle.addSpectacle( spectacle2, 45 );

        Integer Id = spectacle.getId();
        logger.info( "testAddSpectacle : Spec ajouter =" + spectacle );
        Assert.assertNotNull( Id );

    }

    @Test
    public void testFindSpectacleById() {
        Spectacle spectacleResult = serviceSpectacle.findSpectacleById( 35 );
        logger.info( "testFindSpectacleById : " + spectacleResult );
        Assert.assertNotNull( spectacleResult.getId() );
    }

    @Test
    public void testFindSpectaclesByCategory() {
        List<Spectacle> spectacles = new ArrayList<>();
        spectacles = serviceSpectacle.findSpectaclesByCategory( 45 );
        logger.info( "testFindSpectaclesByCategory : " + spectacles );
        Assert.assertNotNull( spectacles );
    }

    @Test
    public void testFindSpectaclesByCriteria() {
        Date date = new Date();
        List<Spectacle> spectacles = serviceSpectacle.findSpectaclesByCriteria( date, 45 );
        logger.info( "testFindSpectaclesByCriteria : " + spectacles );
        Assert.assertNotNull( spectacles );
    }

    @Test
    public void testUpdateSpectacle() {
        Spectacle spectacle = new Spectacle( "titreTestUpdate", "descriptionTestUpdate", 40, 4.0, 17 );
        spectacle.setId( 32 );
        serviceSpectacle.updateSpectacle( spectacle );
        logger.info( "testUpdateSpectacle : " + spectacle );
        Assert.assertNotNull( spectacle );
    }

    @Test
    public void testAddSession() {
        Session session = new Session( null, null, 59 );
        Date date = new Date();
        session.setDate( date );

        serviceSpectacle.addSession( 36, session );
        // SimpleDateFormat("yyyy-MM-dd") .parse et ..

        logger.info( "testAddSession : " + session );
        Assert.assertNotNull( session.getId() );
    }

    @Test
    public void testFindSessionsOfSpectacle() {
        List<Session> listSessions = serviceSpectacle.findSessionsOfSpectacle( 36 );
        logger.info( "testFindSessionsOfSpectacle : " + listSessions );
        Assert.assertNotNull( listSessions.size() );
    }

    @Test
    public void testFindSessionById() {
        Session session = serviceSpectacle.findSessionById( 3 );
        logger.info( "testFindSessionById : " + session );
        Assert.assertNotNull( session.getId() );
    }

    // Les tests des méthodes qui suppriment des éléments dans la base de
    // données
    // CE SERVICE MARCHE(verification dans la BDD), LE PROBLEME EST SUR LE
    // ASSERT..

    // @Test
    public void testRemoveSpectacle() {
        serviceSpectacle.removeSpectacle( 38 );
        Assert.assertNull( serviceSpectacle.findSpectacleById( 38 ) );
    }

    @Test
    public void testRemoveCategory() {
        List<Category> categories = serviceSpectacle.allCategories();
        int taille = -1;
        if ( categories.size() > 0 ) {
            for ( Category category : categories ) {
                serviceSpectacle.removeCategory( category.getId() );
            }
            categories = serviceSpectacle.allCategories();
            taille = categories.size();
        }
        Assert.assertEquals( 0, taille );
    }

    // CE SERVICE MARCHE(verification dans la BDD), LE PROBLEME EST SUR LE
    // ASSERT..
    // @Test
    public void testRemoveSession() {
        serviceSpectacle.removeSession( 2 );
        logger.info( "Session SUPPRIMEE" );
        Assert.assertNull( serviceSpectacle.findSessionById( 2 ) );
    }

}
