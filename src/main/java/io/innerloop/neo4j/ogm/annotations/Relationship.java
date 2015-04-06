package io.innerloop.neo4j.ogm.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by markangrish on 07/11/2014.
 */
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Relationship
{
    String INCOMING = "INCOMING";
    String OUTGOING = "OUTGOING";
    String UNDIRECTED = "UNDIRECTED";

    String type() default "";

    String direction() default UNDIRECTED;
}
