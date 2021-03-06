package io.innerloop.neo4j.ogm.impl.converters;


import io.innerloop.neo4j.ogm.Converter;

import java.time.Year;

/**
 * Created by markangrish on 09/06/2014.
 */

public class YearConverter implements Converter<Year, String>
{
    @Override
    public String serialize(Year year)
    {
        return year.toString();
    }

    @Override
    public Year deserialize(String target)
    {
        return Year.parse(target);
    }
}
