package fr.m2iformation.resaspectacle.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories( basePackages = { "fr.m2iformation.resaspectacle.repos" } )
@EntityScan( basePackages = { "fr.m2iformation.resaspectacle.models" } )
@ComponentScan( basePackages = { "fr.m2iformation.resaspectacle" } ) // needed
public class WithAutoConfiguration {
    // la configuration automatique tient compte des éléments
    // présents dans le classpath (selon pom.xml)
    // et du fichier application.properties
}
