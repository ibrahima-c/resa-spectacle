package fr.m2iformation.resaspectacle.services;

import java.util.Date;
import java.util.List;

import fr.m2iformation.resaspectacle.models.spectacles.Category;
import fr.m2iformation.resaspectacle.models.spectacles.Session;
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;

public interface ISpectacleService {

    void addCategory( Category category );

    void removeCategory( Integer categoryId );

    List<Category> allCategories();

    List<Spectacle> findSpectaclesByCategory( Integer categoryId );

    List<Spectacle> findSpectaclesByCriteria( Date date, Integer categoryId );

    void addSpectacle( Spectacle spectacle, Integer categoryId );

    void updateSpectacle( Spectacle spectacle );

    void removeSpectacle( Integer spectacleId );

    void addSession( Integer spectacleId, Session session );

    List<Session> findSessionsOfSpectacle( Integer spectacleId );

    Session findSessionById( Integer sessionId );

    void removeSession( Integer sessionId );

    Spectacle findSpectacleById( Integer spectacleId );
}
