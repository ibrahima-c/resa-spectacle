package fr.m2iformation.resaspectacle.models.spectacles;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.m2iformation.resaspectacle.models.abstraits.AbstractEntity;

@Entity
public class Session extends AbstractEntity {

    @Temporal( TemporalType.DATE )
    private Date      date;

    @Temporal( TemporalType.TIME )
    private Date      startTime;

    private Integer   nbRemainingPlaces;

    @ManyToOne
    private Spectacle spectacle;

    public Session( Date date, Date startTime, Integer nbRemainingPlaces ) {
        this.date = date;
        this.startTime = startTime;
        this.nbRemainingPlaces = nbRemainingPlaces;
    }

    public Session() {
        this( null, null, null );
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime( Date startTime ) {
        this.startTime = startTime;
    }

    public Integer getNbRemainingPlaces() {
        return nbRemainingPlaces;
    }

    public void setNbRemainingPlaces( Integer nbRemainingPlaces ) {
        this.nbRemainingPlaces = nbRemainingPlaces;
    }

    public Spectacle getSpectacle() {
        return spectacle;
    }

    public void setSpectacle( Spectacle spectacle ) {
        this.spectacle = spectacle;
    }

    @Override
    public String toString() {
        return "Session [date=" + date + ", startTime=" + startTime + ", nbRemainingPlaces=" + nbRemainingPlaces + "]";
    }

}
