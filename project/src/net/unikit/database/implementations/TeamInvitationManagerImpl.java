package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundException;
import net.unikit.database.internal.interfaces.entities.TeamInvitationModel;
import net.unikit.database.interfaces.entities.TeamInvitation;
import net.unikit.database.interfaces.managers.TeamInvitationManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamInvitationManagerImpl implements TeamInvitationManager {
    private DatabaseManagerImpl databaseManager;

    private TeamInvitationManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static TeamInvitationManager create(DatabaseManagerImpl databaseManager) {
        return new TeamInvitationManagerImpl(databaseManager);
    }

    @Override
    public List<TeamInvitation> getAllEntities() {
        List<TeamInvitationModel> allEntities = databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().getAllEntities();
        ImmutableList.Builder<TeamInvitation> builder = ImmutableList.builder();
        for (TeamInvitationModel entity : allEntities) {
            builder.add(TeamInvitationImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public TeamInvitation getEntity(TeamInvitation.ID id) throws EntityNotFoundException {
        try {
            TeamInvitationModel entity = databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().getEntity(id.getValue());
            return TeamInvitationImpl.create(entity);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(TeamInvitation entity) throws EntityNotFoundException {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().updateEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public void deleteEntity(TeamInvitation entity) throws EntityNotFoundException {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().deleteEntity(model);
        } catch (ModelNotFoundException e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public TeamInvitation.ID addEntity(TeamInvitation entity) {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        Integer id = databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().addEntity(model);
        return new TeamInvitationImpl.IDImpl(id);
    }

    @Override
    public TeamInvitation createEntity() {
        TeamInvitationModel model = databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().createEntity();
        return TeamInvitationImpl.create(model);
    }

    @Override
    public TeamInvitation.ID createID(Integer value) {
        return new TeamInvitationImpl.IDImpl(value);
    }
}
