package io.innerloop.neo4j.ogm.models.complex;

import io.innerloop.neo4j.ogm.annotations.Id;
import io.innerloop.neo4j.ogm.generators.UuidGenerator;

import java.util.UUID;

/**
 * Created by markangrish on 30/03/2015.
 */
public class Alias
{
    private Long id;

    @Id
    private UUID uuid;

    private String name;

    public Alias()
    {
    }

    public Alias(String name)
    {
        this.uuid = UuidGenerator.generate();
        this.name = name;
    }
}
