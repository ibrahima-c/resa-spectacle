package fr.m2iformation.resaspectacle.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.m2iformation.resaspectacle.models.spectacles.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
