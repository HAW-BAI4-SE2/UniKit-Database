package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.interfaces.entities.TeamInvitation;
import net.unikit.database.interfaces.managers.TeamInvitationManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamInvitationManagerImpl implements TeamInvitationManager {
    @Override
    public List<TeamInvitation> getAllEntities() {
        List<TeamInvitationModel> allEntities = DatabaseManagerFactory.getInternalDatabaseManager().getTeamInvitationModelManager().getAllEntities();
        ImmutableList.Builder<TeamInvitation> builder = ImmutableList.builder();
        for (TeamInvitationModel entity : allEntities) {
            builder.add(TeamInvitationImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public TeamInvitation getEntity(TeamInvitation.ID id) {
        TeamInvitationModel entity = DatabaseManagerFactory.getInternalDatabaseManager().getTeamInvitationModelManager().getEntity(id.getValue());
        return TeamInvitationImpl.create(entity);
    }

    @Override
    public void updateEntity(TeamInvitation entity) {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamInvitationModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(TeamInvitation entity) {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamInvitationModelManager().deleteEntity(model);
    }

    @Override
    public TeamInvitation.ID addEntity(TeamInvitation entity) {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getInternalDatabaseManager().getTeamInvitationModelManager().addEntity(model);
        return new TeamInvitationImpl.IDImpl(id);
    }

    @Override
    public TeamInvitation createEntity() {
        return TeamInvitationImpl.create(null);
    }
}
