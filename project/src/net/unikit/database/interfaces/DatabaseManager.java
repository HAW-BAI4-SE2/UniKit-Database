package net.unikit.database.interfaces;

import net.unikit.database.interfaces.managers.*;

/**
 * A manager which grants access to all database managers.
 * @author Andreas Berks
 * @since 1.2.1
 */
public interface DatabaseManager {
    /**
     * Getter for the manager for the course group appointments.
     * @return The manager for the course group appointments
     */
    CourseGroupAppointmentManager getCourseGroupAppointmentManager();

    /**
     * Getter for the manager for the course groups.
     * @return The manager for the course groups
     */
    CourseGroupManager getCourseGroupManager();

    /**
     * Getter for the manager for the course lecture appointments.
     * @return The manager for the course lecture appointments
     */
    CourseLectureAppointmentManager getCourseLectureAppointmentManager();

    /**
     * Getter for the manager for the course lectures.
     * @return The manager for the course lectures
     */
    CourseLectureManager getCourseLectureManager();

    /**
     * Getter for the manager for the courses.
     * @return The manager for the courses
     */
    CourseManager getCourseManager();

    /**
     * Getter for the manager for the course registrations.
     * @return The manager for the course registrations
     */
    CourseRegistrationManager getCourseRegistrationManager();

    /**
     * Getter for the manager for the field of studies.
     * @return The manager for the field of studies
     */
    FieldOfStudyManager getFieldOfStudyManager();

    /**
     * Getter for the manager for the membership requests.
     * @return The manager for the membership requests
     */
    MembershipRequestManager getMembershipRequestManager();

    /**
     * Getter for the manager for the students.
     * @return The manager for the students
     */
    StudentManager getStudentManager();

    /**
     * Getter for the manager for the team invitations.
     * @return The manager for the team invitations
     */
    TeamInvitationManager getTeamInvitationManager();

    /**
     * Getter for the manager for the teams.
     * @return The manager for the teams
     */
    TeamManager getTeamManager();

    /**
     * Getter for the manager for the team registrations.
     * @return The manager for the team registrations
     */
    TeamRegistrationManager getTeamRegistrationManager();
}
