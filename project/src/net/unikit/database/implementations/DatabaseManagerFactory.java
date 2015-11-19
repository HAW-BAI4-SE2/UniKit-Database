package net.unikit.database.implementations;

import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;

public final class DatabaseManagerFactory {
    public static DatabaseManager createDatabaseManager(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        return DatabaseManagerImpl.create(internalConfiguration, externalConfiguration);
    }
}
