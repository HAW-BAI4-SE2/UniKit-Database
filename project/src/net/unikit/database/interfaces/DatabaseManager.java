package net.unikit.database.interfaces;

import net.unikit.database.interfaces.managers.*;

public interface DatabaseManager {
    AppointmentManager getAppointmentManager();
    CourseGroupManager getCourseGroupManager();
    CourseLectureManager getCourseLectureManager();
    CourseManager getCourseManager();
    CourseRegistrationManager getCourseRegistrationManager();
    DidacticUnitManager getDidacticUnitManager();
    FieldOfStudyManager getFieldOfStudyManager();
    MembershipRequestManager getMembershipRequestManager();
    StudentManager getStudentManager();
    TeamInvitationManager getTeamInvitationManager();
    TeamManager getTeamManager();
    TeamRegistrationManager getTeamRegistrationManager();
}
