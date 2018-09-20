package fr.m2iformation.resaspectacle.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonAop {

    /**
     * S'execute avant chaque methode
     * 
     * @param jp
     */
    @Before( "execution(* fr.m2iformation.resaspectacle.service.*.*(..))" )
    public void beforeMethode( JoinPoint jp ) {

        System.out.println( "" );

        String methode = jp.getSignature().toShortString();
        Object[] args = jp.getArgs();
        System.out.println( String.format( "==AOP @Before==   Execution de la methode %s", methode ) );
        System.out.println( "==AOP @Before==   Avec les arguments suivants : " );
        for ( int i = 0; i < args.length; i++ ) {
            System.out.println( String.format( "==AOP @Before==   Arg %s = %s", i, args[i] ) );
        }

    }

    /**
     * S'execute après la methode
     * 
     * @param jp
     * @param resultat
     */
    @AfterReturning( value = "execution(* fr.m2iformation.resaspectacle.service.*.*(..))", returning = "resultat" )
    public void afterMethode( JoinPoint jp, Object resultat ) {

        System.out.println(
                resultat != null ? "==AOP @AfterReturning==   Resultat retourné => " + resultat.toString()
                        : "==AOP @AfterReturning==   Pas de valeur de retour" );

        System.out.println( "" );

    }

    @Around( "execution(* fr.m2iformation.resaspectacle.service.*.*(..))" )
    public Object whileMethode( ProceedingJoinPoint jpj ) throws Throwable {

        long debut = System.currentTimeMillis();
        Object object = jpj.proceed();
        long fin = System.currentTimeMillis();
        System.out.println( String.format( "==AOP @Around==   Temps = %s ms", ( fin - debut ) ) );
        return object;

    }
}
