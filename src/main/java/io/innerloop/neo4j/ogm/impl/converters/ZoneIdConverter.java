package io.innerloop.neo4j.ogm.impl.converters;

import io.innerloop.neo4j.ogm.Converter;

import java.time.ZoneId;

/**
 * Created by markangrish on 10/06/2014.
 */
public class ZoneIdConverter implements Converter<ZoneId, String>
{
    @Override
    public String serialize(ZoneId source)
    {
        return source.getId();
    }

    @Override
    public ZoneId deserialize(String id)
    {
        return ZoneId.of(id);
    }
}
