package fr.m2iformation.resaspectacle.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.m2iformation.resaspectacle.models.spectacles.Category;
import fr.m2iformation.resaspectacle.models.spectacles.Session;
import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;
import fr.m2iformation.resaspectacle.repos.CategoryRepository;
import fr.m2iformation.resaspectacle.repos.SessionRepository;
import fr.m2iformation.resaspectacle.repos.SpectacleRepository;
import fr.m2iformation.resaspectacle.services.ISpectacleService;

@Service
@Transactional
public class SpectacleService implements ISpectacleService {

    @Autowired
    private SpectacleRepository spectacleDao;

    @Autowired
    private CategoryRepository  categoryDao;

    @Autowired
    private SessionRepository   sessionDao;

    @Override
    public void addCategory( Category category ) {
    	categoryDao.save( category );
    }

    @Override
    public void removeCategory( Integer categoryId ) {
        categoryDao.deleteById( categoryId );
    }

    @Override
    public List<Category> allCategories() {
        return categoryDao.findAll();
    }

    @Override
    public List<Spectacle> findSpectaclesByCategory( Integer categoryId ) {
        return spectacleDao.findByCategory_Id( categoryId );
    }

    @Override
    public List<Spectacle> findSpectaclesByCriteria( Date date, Integer categoryId ) {
        List<Session> listSessions = sessionDao.findByDate( date );
        List<Spectacle> listSpectacles = new ArrayList<>();
        if ( listSessions != null ) {
            for ( Session session : listSessions ) {
                if ( session.getSpectacle().getCategory().getId() == categoryId ) {
                    listSpectacles.add( session.getSpectacle() );
                }
            }
        }
        return listSpectacles;
    }

    @Override
    public Spectacle findSpectacleById( Integer spectacleId ) {
    	Optional<Spectacle> spectacleOptional = spectacleDao.findById(spectacleId);
        return spectacleOptional.get();
    }

    @Override
    public void addSpectacle( Spectacle spectacle, Integer categoryId ) {
        spectacle.setCategory( categoryDao.getOne( categoryId ) );
        spectacleDao.save( spectacle );
    }

    @Override
    public void updateSpectacle( Spectacle spectacle ) {
        spectacleDao.save( spectacle );
    }

    @Override
    public void removeSpectacle( Integer spectacleId ) {
        spectacleDao.deleteById( spectacleId );
    }

    @Override
    public void addSession( Integer spectacleId, Session session ) {
        session.setSpectacle( spectacleDao.getOne( spectacleId ) );
        sessionDao.save( session );
    }

    @Override
    public List<Session> findSessionsOfSpectacle( Integer spectacleId ) {
        return sessionDao.findBySpectacle_Id( spectacleId );
    }

    @Override
    public Session findSessionById( Integer sessionId ) {
    	Optional<Session> sessionOptional = sessionDao.findById(sessionId);
        return sessionOptional.get();
    }

    @Override
    public void removeSession( Integer sessionId ) {
        sessionDao.deleteById( sessionId );
    }

}
