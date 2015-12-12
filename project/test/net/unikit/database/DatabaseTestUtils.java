package net.unikit.database;

import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.interfaces.managers.MembershipRequestManager;
import net.unikit.database.interfaces.managers.StudentManager;
import net.unikit.database.interfaces.managers.TeamManager;

/**
 * Created by Andreas on 12.12.2015.
 */
public class DatabaseTestUtils {
    public static Student getStudent(String studentNumber) {
        StudentManager studentManager = TestSuite.getDatabaseManager().getStudentManager();
        try {
            Student student = studentManager.getEntity(studentManager.createID(studentNumber));
            return student;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    public static Team getTeam(int id) {
        TeamManager teamManager = TestSuite.getDatabaseManager().getTeamManager();
        try {
            Team team = teamManager.getEntity(teamManager.createID(id));
            return team;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }

    public static MembershipRequest getMembershipRequest(int id) {
        MembershipRequestManager membershipRequestManager = TestSuite.getDatabaseManager().getMembershipRequestManager();
        try {
            MembershipRequest team = membershipRequestManager.getEntity(membershipRequestManager.createID(id));
            return team;
        } catch (EntityNotFoundException e) {
            throw new IllegalStateException();
        }
    }
}
