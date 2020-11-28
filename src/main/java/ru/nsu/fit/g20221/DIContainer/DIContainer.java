package ru.nsu.fit.g20221.DIContainer;

import java.io.InputStream;
import java.util.Collection;
import java.util.Optional;

/**
 * Dependency injection container.
 * Can creates objects from configuration using dependency injection from constructor.
 */
public interface DIContainer {

    /**
     * @param object registered object.
     * @param name object's name.
     */
    void registerObject(Object object, String name);

    /**
     * Load configuration to the container.
     *
     * @param config configuration in xml format.
     * @see TODO add link to xml config format
     */
    void loadConfig(InputStream config);


    /**
     * @return names of registered objects.
     */
    Collection<String> getObjectNames();

    /**
     * @param name object's name.
     * @return object from container.
     */
    Optional<Object> getObject(String name);

    /**
     * Remove object from container. Also calls {@link javax.annotation.PreDestroy} annotated methods of object.
     *
     * @param name object's name.
     */
    void unregisterObject(String name);

    /**
     * Close container. Calls {@link javax.annotation.PreDestroy} annotated methods of registered objects.
     */
    void close();

}
