package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.ExternalDatabaseManager;
import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.internal.interfaces.InternalDatabaseManager;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DatabaseManagerFactory {
    static DatabaseManager databaseManager;

    public static DatabaseManager getDatabaseManager() {
        checkNotNull(databaseManager, "databaseManager is null!");
        return databaseManager;
    }

    public static DatabaseManager createDatabaseManager(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        DatabaseManager databaseManager = DatabaseManagerImpl.create(internalConfiguration, externalConfiguration);
        DatabaseManagerFactory.databaseManager = databaseManager;
        return databaseManager;
    }
}
