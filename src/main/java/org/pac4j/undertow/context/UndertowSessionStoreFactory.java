package org.pac4j.undertow.context;

import org.pac4j.core.context.FrameworkParameters;
import org.pac4j.core.context.session.SessionStore;
import org.pac4j.core.context.session.SessionStoreFactory;
import org.pac4j.core.exception.TechnicalException;

/**
 * Build a JEE session store from parameters.
 *
 * @author Jerome LELEU
 * @since 5.5.0
 */
public class UndertowSessionStoreFactory implements SessionStoreFactory {

    /** Constant <code>INSTANCE</code> */
    public static final SessionStoreFactory INSTANCE = new UndertowSessionStoreFactory();
    
    /**
     * {@inheritDoc}
     *
     * Create the session store.
     */
    @Override
    public SessionStore newSessionStore(final FrameworkParameters parameters) {
        if (parameters instanceof UndertowParameters undertowParameters) {
            return new UndertowSessionStore(undertowParameters.exchange());
        }
        throw new TechnicalException("Bad parameters type");
    }
}