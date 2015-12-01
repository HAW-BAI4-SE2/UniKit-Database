package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.managers.TeamManager;
import net.unikit.database.exceptions.ConstraintViolationExceptionCommon;
import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundExceptionCommon;
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
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(TeamInvitation entity) throws EntityNotFoundException, ConstraintViolationException {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(TeamInvitation entity) throws EntityNotFoundException {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public TeamInvitation.ID addEntity(TeamInvitation entity) throws ConstraintViolationException {
        TeamInvitationModel model = ((TeamInvitationImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getInternalDatabaseManager().getTeamInvitationModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
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

    @Override
    public TeamInvitation getInvitation(Student invitedStudent, Team invitingTeam) throws NullPointerException, EntityNotFoundException {
        TeamInvitation requestedInvitation = null;

        // Find invitation
        for(TeamInvitation currentInvitation : getAllEntities()){
            if(currentInvitation.getInvitee().equals(invitedStudent) &&
                    currentInvitation.getTeam().equals(invitingTeam)){
                requestedInvitation = currentInvitation;
                break;
            }
        }

        return requestedInvitation;
    }
}
