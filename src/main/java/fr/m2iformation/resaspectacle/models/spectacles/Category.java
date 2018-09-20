package fr.m2iformation.resaspectacle.models.spectacles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import fr.m2iformation.resaspectacle.models.abstraits.AbstractEntity;

@Entity
public class Category extends AbstractEntity {

    private CategoryName   title;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "category_id" )
    private Set<Spectacle> spectacles;

    public Category( CategoryName title ) {
        this.title = title;
    }

    public Category() {
        this( null );
    }

    public CategoryName getTitle() {
        return title;
    }

    public void setTitle( CategoryName title ) {
        this.title = title;
    }

    public Set<Spectacle> getSpectacles() {
        if ( spectacles == null ) {
            spectacles = new HashSet<>();
        }
        return spectacles;
    }

    public void setSpectacles( Set<Spectacle> spectacles ) {
        this.spectacles = spectacles;
    }

    @Override
    public String toString() {
        return "Category [title=" + title + "]";
    }

}
