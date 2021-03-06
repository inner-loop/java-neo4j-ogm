package io.innerloop.neo4j.ogm.impl.converters;



import io.innerloop.neo4j.ogm.Converter;

import java.util.UUID;

/**
 * Created by markangrish on 11/11/2014.
 */
public class UUIDConverter implements Converter<UUID, String>
{
    @Override
    public String serialize(UUID source)
    {
        return source.toString();
    }

    @Override
    public UUID deserialize(String value)
    {
        return UUID.fromString(value);
    }
}
