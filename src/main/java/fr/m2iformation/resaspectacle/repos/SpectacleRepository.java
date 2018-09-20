package fr.m2iformation.resaspectacle.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.resaspectacle.models.spectacles.Spectacle;

public interface SpectacleRepository extends JpaRepository<Spectacle, Integer> {
    List<Spectacle> findByCategory_Id( Integer categoryId );
}
