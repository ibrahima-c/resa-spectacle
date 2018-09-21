package fr.m2iformation.resaspectacle;

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
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;
import fr.m2iformation.resaspectacle.services.ISpectacleService;

@RunWith( SpringRunner.class )
@SpringBootTest( classes = { WithAutoConfiguration.class } )
public class ResaSpectacleApplicationTests {

    private static Logger     logger = LoggerFactory.getLogger( ResaSpectacleApplicationTests.class );

    @Autowired
    private ISpectacleService serviceSpectacle;

    @Test
    public void testAddCategory() {
        Category category = new Category( CategoryName.Concert.getName() );
        serviceSpectacle.addCategory( category );
        Integer Id = category.getId();
        logger.info( "TestAddCategory : id=" + Id );
        Assert.assertTrue( Id != null );
    }

    @Test
    public void testAllCategories() {
        Category category = new Category( CategoryName.Theatre.getName() );
        serviceSpectacle.addCategory( category );
        List<Category> categories = serviceSpectacle.allCategories();
        logger.info( "TestAllCategory : listes des catégories =" + categories );
        Assert.assertTrue( categories.size() > 0 );

    }

    @Test
    public void testAddSpectacle() {
        Category category = new Category( CategoryName.Concert.getName() );
        serviceSpectacle.addCategory( category );
        Spectacle spectacle = new Spectacle( "titreTestAdd", "descriptionTestAdd", 240, 40.0, 300 );
        serviceSpectacle.addSpectacle( spectacle, category.getId() );
        Integer Id = spectacle.getId();
        logger.info( "testAddSpectacle : Spec ajouter =" + spectacle );
        Assert.assertTrue( Id != null );

    }

    @Test
    public void testFindSpectacleById() {
        Category category = new Category( CategoryName.Concert.getName() );
        serviceSpectacle.addCategory( category );
        Spectacle spectacle = new Spectacle( "titreTest", "descriptionTest", 240, 40.0, 300 );
        serviceSpectacle.addSpectacle( spectacle, category.getId() );
        logger.info( "testFindSpectacleById : " + spectacle );
        serviceSpectacle.findSpectacleById( spectacle.getId() );
        Assert.assertNotNull( spectacle.getId() );

    }

    // @Test
    public void testFindSpectaclesByCategory() {

    }

    // @Test
    public void testFindSpectaclesByCriteria() {

    }

    // @Test
    public void testUpdateSpectacle() {

    }

    // @Test
    public void testAddSession() {

    }

    // @Test
    public void testFindSessionsOfSpectacle() {

    }

    // @Test
    public void testFindSessionById() {

    }

    // Les tests des méthodes qui suppriment des éléments dans la base de
    // données

    // @Test
    public void testRemoveSpectacle() {

    }

    // @Test
    // public void testRemoveCategory() {
    // List<Category> categories = serviceSpectacle.allCategories();
    // int taille = -1;
    // if ( categories.size() > 0 ) {
    // for ( Category category : categories ) {
    // serviceSpectacle.removeCategory( category.getId() );
    // }
    // categories = serviceSpectacle.allCategories();
    // taille = categories.size();
    // }
    // Assert.assertEquals( 0, taille );
    // }

    // @Test
    public void testRemoveSession() {

    }

}
