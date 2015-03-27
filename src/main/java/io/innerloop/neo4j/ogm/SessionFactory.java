package io.innerloop.neo4j.ogm;

import io.innerloop.neo4j.client.Neo4jClient;
import io.innerloop.neo4j.ogm.impl.mapping.CypherQueryMapper;
import io.innerloop.neo4j.ogm.impl.mapping.GraphResultMapper;
import io.innerloop.neo4j.ogm.impl.metadata.MetadataMap;

/**
 * Created by markangrish on 18/12/2014.
 */
public class SessionFactory
{
    private final Neo4jClient client;

    private final MetadataMap metadataMap;

    public SessionFactory(Neo4jClient client, String... packages)
    {
        this.metadataMap = new MetadataMap(packages);
        this.client = client;
    }

    public Session getCurrentSession()
    {
        return Session.getSession(client, metadataMap);
    }
}
