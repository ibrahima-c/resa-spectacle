package fr.m2iformation.resaspectacle.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.resaspectacle.models.spectacles.Session;

public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findByDate( Date date );

    List<Session> findBySpectacle_Id( Integer spectacleId );
}
