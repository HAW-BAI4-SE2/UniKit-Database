package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.internal.interfaces.entities.TeamModel;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.managers.TeamManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class TeamManagerImpl implements TeamManager {
    @Override
    public List<Team> getAllEntities() {
        List<TeamModel> allEntities = DatabaseManagerFactory.getInternalDatabaseManager().getTeamModelManager().getAllEntities();
        ImmutableList.Builder<Team> builder = ImmutableList.builder();
        for (TeamModel entity : allEntities) {
            builder.add(TeamImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public Team getEntity(Team.ID id) {
        TeamModel entity = DatabaseManagerFactory.getInternalDatabaseManager().getTeamModelManager().getEntity(id.getValue());
        return TeamImpl.create(entity);
    }

    @Override
    public void updateEntity(Team entity) {
        TeamModel model = ((TeamImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(Team entity) {
        TeamModel model = ((TeamImpl)(entity)).model;
        DatabaseManagerFactory.getInternalDatabaseManager().getTeamModelManager().deleteEntity(model);
    }

    @Override
    public Team.ID addEntity(Team entity) {
        TeamModel model = ((TeamImpl)(entity)).model;
        Integer id = DatabaseManagerFactory.getInternalDatabaseManager().getTeamModelManager().addEntity(model);
        return new TeamImpl.IDImpl(id);
    }

    @Override
    public Team createEntity() {
        return TeamImpl.create(null);
    }
}
