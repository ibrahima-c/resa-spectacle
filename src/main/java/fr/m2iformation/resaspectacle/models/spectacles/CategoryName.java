package fr.m2iformation.resaspectacle.models.spectacles;

public enum CategoryName {
    Film( "Film" ), Theatre( "Theatre" ), Concert( "Concert" ), Cirque( "Cirque" );

    private final String name;

    CategoryName(
            String nom ) {
        this.name = nom;
    }

    public String getName() {
        return name;
    }

}
