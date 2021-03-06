package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.exceptions.*;
import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.managers.TeamManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamManagerImpl extends AbstractEntityImpl implements TeamManager {
    private DatabaseManagerImpl databaseManager;

    private TeamManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static TeamManager create(DatabaseManagerImpl databaseManager) {
        return new TeamManagerImpl(databaseManager);
    }

    @Override
    public List<Team> getAllEntities() {
        List<TeamModel> allEntities = databaseManager.getInternalDatabaseManager().getTeamModelManager().getAllEntities();
        ImmutableList.Builder<Team> builder = ImmutableList.builder();
        for (TeamModel entity : allEntities) {
            builder.add(TeamImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Team getEntity(Team.ID id) throws EntityNotFoundException {
        try {
            TeamModel entity = databaseManager.getInternalDatabaseManager().getTeamModelManager().getEntity(id.getValue());
            return TeamImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(Team entity) throws EntityNotFoundException, ConstraintViolationException {
        TeamModel model = ((TeamImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        } catch (MissingPropertyExceptionCommon missingPropertyExceptionCommon) {
            throw new MissingPropertyException(missingPropertyExceptionCommon.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(Team entity) throws EntityNotFoundException {
        TeamModel model = ((TeamImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getTeamModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ModelNotAddedExceptionCommon modelNotAddedExceptionCommon) {
            throw new EntityNotAddedException(entity);
        }
    }

    @Override
    public Team.ID addEntity(Team entity) throws ConstraintViolationException {
        TeamModel model = ((TeamImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getInternalDatabaseManager().getTeamModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        } catch (MissingPropertyExceptionCommon missingPropertyExceptionCommon) {
            throw new MissingPropertyException(missingPropertyExceptionCommon.getCause(), entity);
        }
        return new TeamImpl.IDImpl(id);
    }

    @Override
    public Team createEntity() {
        TeamModel model = databaseManager.getInternalDatabaseManager().getTeamModelManager().createEntity();
        return TeamImpl.create(model);
    }

    @Override
    public Team.ID createID(Integer value) {
        return new TeamImpl.IDImpl(value);
    }

    @Override
    public Team getTeam(int teamID) throws EntityNotFoundException {
        return getEntity(createID(teamID));
    }
}
