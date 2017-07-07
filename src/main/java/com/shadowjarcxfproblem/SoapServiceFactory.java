package com.shadowjarcxfproblem;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoapServiceFactory<T> {

    /// URL to endpoint
    private final String endpoint;

    /// Timeout in milliseconds
    private final int timeout;

    /// Handle to the service that will be created
    private final Class<T> clazz;

    private final JaxWsProxyFactoryBean factory;

    private final Logger log = LoggerFactory.getLogger(SoapServiceFactory.class);

    public SoapServiceFactory(String endpoint, int timeout, Class<T> clazz) {
        this.endpoint = endpoint;
        this.timeout = timeout;
        this.clazz = clazz;

        this.factory = createJaxWsProxyFactoryBean();
    }

    public T create() {
        @SuppressWarnings("unchecked")
        T service = (T) factory.create();
        Client client = ClientProxy.getClient(service);

        setTimeout(client);

        log.info("Created soap service '" + clazz.getName() + "' with endpoint '" + endpoint + "' and timeout '" + timeout + "'");

        return service;
    }

    public JaxWsProxyFactoryBean getJaxWsProxyFactory() {
        return factory;
    }

    private void setTimeout(Client client) {
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(timeout);
        policy.setReceiveTimeout(timeout);
        conduit.setClient(policy);
    }

    private JaxWsProxyFactoryBean createJaxWsProxyFactoryBean() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

        factory.getServiceFactory().setWrapped(true);
        factory.setServiceClass(clazz);
        factory.setAddress(endpoint);

        return factory;
    }
}
