package io.innerloop.neo4j.ogm.impl.converters;


import io.innerloop.neo4j.ogm.Converter;

import java.util.Currency;

/**
 * Created by markangrish on 10/06/2014.
 */
public class CurrencyConverter implements Converter<Currency, String>
{
    @Override
    public String serialize(Currency currency)
    {
        return currency.getCurrencyCode();
    }

    @Override
    public Currency deserialize(String currencyCode)
    {
        return Currency.getInstance(currencyCode);
    }
}
