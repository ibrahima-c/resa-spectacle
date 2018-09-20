package fr.m2iformation.resaspectacle.models.spectacles;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import fr.m2iformation.resaspectacle.models.abstraits.AbstractEntity;

@Entity
public class Spectacle extends AbstractEntity {

    private String       title;
    private String       description;
    private Integer      duration;
    private Double       price;
    private Integer      nbPlaces;

    @OneToMany( cascade = CascadeType.ALL )
    @JoinColumn( name = "spectacle_id" )
    private Set<Session> sessions;

    @ManyToOne
    private Category     category;

    public Spectacle( String title, String description, Integer duration, Double price, Integer nbPlaces ) {
        this.title = title;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.nbPlaces = nbPlaces;
    }

    public Spectacle() {
        this( null, null, null, null, null );
    }

    public String getTitle() {
        return title;
    }

    public void setTitle( String title ) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration( Integer duration ) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice( Double price ) {
        this.price = price;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces( Integer nbPlaces ) {
        this.nbPlaces = nbPlaces;
    }

    public Set<Session> getSessions() {
        if ( sessions == null ) {
            sessions = new HashSet<>();
        }
        return sessions;
    }

    public void setSessions( Set<Session> sessions ) {
        this.sessions = sessions;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory( Category category ) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Spectacle [title=" + title + ", description=" + description + ", duration=" + duration + ", price="
                + price + ", nbPlaces=" + nbPlaces + "]";
    }

}
