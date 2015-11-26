package net.unikit.database.implementations;

import net.unikit.database.external.interfaces.ExternalDatabaseManager;
import net.unikit.database.interfaces.DatabaseConfiguration;
import net.unikit.database.interfaces.DatabaseManager;
import net.unikit.database.internal.interfaces.InternalDatabaseManager;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DatabaseManagerFactory {
    static DatabaseManager databaseManager;
    static InternalDatabaseManager internalDatabaseManager;
    static ExternalDatabaseManager externalDatabaseManager;

    public static DatabaseManager getDatabaseManager() {
        checkNotNull(databaseManager, "databaseManager is null!");
        return databaseManager;
    }

    public static InternalDatabaseManager getInternalDatabaseManager() {
        checkNotNull(internalDatabaseManager, "internalDatabaseManager is null!");
        return internalDatabaseManager;
    }

    public static ExternalDatabaseManager getExternalDatabaseManager() {
        checkNotNull(externalDatabaseManager, "externalDatabaseManager is null!");
        return externalDatabaseManager;
    }

    public static DatabaseManager createDatabaseManager(DatabaseConfiguration internalConfiguration, DatabaseConfiguration externalConfiguration) {
        DatabaseManager databaseManager = DatabaseManagerImpl.create(internalConfiguration, externalConfiguration);
        DatabaseManagerFactory.databaseManager = databaseManager;
        return databaseManager;
    }
}
