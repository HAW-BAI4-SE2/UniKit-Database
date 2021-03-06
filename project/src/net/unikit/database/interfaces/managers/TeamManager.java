package net.unikit.database.interfaces.managers;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.Team;

/**
 * A manager for the teams.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface TeamManager extends AbstractManager<Team, Integer, Team.ID> {
    Team getTeam(int teamID) throws EntityNotFoundException;
}
