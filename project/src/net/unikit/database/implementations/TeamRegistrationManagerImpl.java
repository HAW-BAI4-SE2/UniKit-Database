package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundException;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;
import net.unikit.database.interfaces.entities.TeamRegistration;
import net.unikit.database.interfaces.managers.TeamRegistrationManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamRegistrationManagerImpl implements TeamRegistrationManager {
    private DatabaseManagerImpl databaseManager;

    private TeamRegistrationManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static TeamRegistrationManager create(DatabaseManagerImpl databaseManager) {
        return new TeamRegistrationManagerImpl(databaseManager);
    }

    @Override
    public List<TeamRegistration> getAllEntities() {
        List<TeamRegistrationModel> allEntities = databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().getAllEntities();
        ImmutableList.Builder<TeamRegistration> builder = ImmutableList.builder();
        for (TeamRegistrationModel entity : allEntities) {
            builder.add(TeamRegistrationImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public TeamRegistration getEntity(TeamRegistration.ID id) throws EntityNotFoundException {
        try {
            TeamRegistrationModel entity = databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().getEntity(id.getValue());
            return TeamRegistrationImpl.create(entity);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(TeamRegistration entity) throws EntityNotFoundException {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().updateEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public void deleteEntity(TeamRegistration entity) throws EntityNotFoundException {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().deleteEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public TeamRegistration.ID addEntity(TeamRegistration entity) {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        Integer id = databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().addEntity(model);
        return new TeamRegistrationImpl.IDImpl(id);
    }

    @Override
    public TeamRegistration createEntity() {
        TeamRegistrationModel model = databaseManager.getInternalDatabaseManager().getTeamRegistrationModelManager().createEntity();
        return TeamRegistrationImpl.create(model);
    }

    @Override
    public TeamRegistration.ID createID(Integer value) {
        return new TeamRegistrationImpl.IDImpl(value);
    }
}
