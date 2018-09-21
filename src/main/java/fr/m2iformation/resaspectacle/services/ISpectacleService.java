package fr.m2iformation.resaspectacle.services;

import java.util.Date;
import java.util.List;

import fr.m2iformation.resaspectacle.models.spectacles.Category;
import fr.m2iformation.resaspectacle.models.spectacles.Session;
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;

public interface ISpectacleService {

    // test OK
    void addCategory( Category category );

    // test OK
    void removeCategory( Integer categoryId );

    // test OK
    List<Category> allCategories();

    // test OK
    List<Spectacle> findSpectaclesByCategory( Integer categoryId );

    // test OK
    List<Spectacle> findSpectaclesByCriteria( Date date, Integer categoryId );

    // test OK
    void addSpectacle( Spectacle spectacle, Integer categoryId );

    // test OK
    void updateSpectacle( Spectacle spectacle );

    // test OK
    void removeSpectacle( Integer spectacleId );

    // test OK
    void addSession( Integer spectacleId, Session session );

    // test OK
    List<Session> findSessionsOfSpectacle( Integer spectacleId );

    // test OK
    Session findSessionById( Integer sessionId );

    // test OK
    void removeSession( Integer sessionId );

    // test OK
    Spectacle findSpectacleById( Integer spectacleId );

}
