package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.internal.interfaces.entities.TeamRegistrationModel;
import net.unikit.database.interfaces.entities.TeamRegistration;
import net.unikit.database.interfaces.managers.TeamRegistrationManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamRegistrationManagerImpl implements TeamRegistrationManager {
    @Override
    public List<TeamRegistration> getAllEntities() {
        List<TeamRegistrationModel> allEntities = DatabaseManagerFactory.getInternalDatabaseManager().getTeamRegistrationModelManager().getAllEntities();
        ImmutableList.Builder<TeamRegistration> builder = ImmutableList.builder();
        for (TeamRegistrationModel entity : allEntities) {
            builder.add(TeamRegistrationImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public TeamRegistration getEntity(TeamRegistration.ID id) {
        TeamRegistrationModel entity = DatabaseManagerFactory.getInternalDatabaseManager().getTeamRegistrationModelManager().getEntity(id.getValue());
        return TeamRegistrationImpl.create(entity);
    }

    @Override
    public void updateEntity(TeamRegistration entity) {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamRegistrationModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(TeamRegistration entity) {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamRegistrationModelManager().deleteEntity(model);
    }

    @Override
    public TeamRegistration.ID addEntity(TeamRegistration entity) {
        TeamRegistrationModel model = ((TeamRegistrationImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getInternalDatabaseManager().getTeamRegistrationModelManager().addEntity(model);
        return new TeamRegistrationImpl.IDImpl(id);
    }

    @Override
    public TeamRegistration createEntity() {
        return TeamRegistrationImpl.create(null);
    }
}
