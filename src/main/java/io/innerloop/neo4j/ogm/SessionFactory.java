package io.innerloop.neo4j.ogm;

import io.innerloop.neo4j.client.Connection;
import io.innerloop.neo4j.client.Neo4jClient;
import io.innerloop.neo4j.client.Neo4jClientException;
import io.innerloop.neo4j.ogm.impl.index.Index;
import io.innerloop.neo4j.ogm.impl.metadata.MetadataMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by markangrish on 18/12/2014.
 */
public class SessionFactory
{
    private static final Logger LOG = LoggerFactory.getLogger(SessionFactory.class);

    private final Neo4jClient client;

    private final MetadataMap metadataMap;

    public SessionFactory(Neo4jClient client, String... packages)
    {
        this.metadataMap = new MetadataMap(packages);
        this.client = client;
        buildIndexes();
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                //TODO: figure out how to close any active connections. probably need a registry.
                LOG.info("Closing all active connections");
            }
        });
    }

    private void buildIndexes()
    {
        for (Index index : metadataMap.getIndexes())
        {
            try
            {
                Connection connection = client.getConnection();
                connection.add(index.drop());
                connection.commit();
            }
            catch (Neo4jClientException n4jce)
            {
                // do nothing...
            }
            try
            {
                Connection connection = client.getConnection();
                connection.add(index.create());
                connection.commit();
            }
            catch (Neo4jClientException n4jce)
            {
                // do nothing...
            }
        }
    }

    public Session getCurrentSession()
    {
        return Session.getSession(client, metadataMap);
    }

    public void close()
    {

    }

    public boolean isOpen()
    {
        return true;
    }
}
