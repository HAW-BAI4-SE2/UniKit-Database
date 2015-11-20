package net.unikit.database.interfaces;

import net.unikit.database.interfaces.managers.*;

public interface DatabaseManager {
    CourseGroupAppointmentManager getCourseGroupAppointmentManager();
    CourseGroupManager getCourseGroupManager();
    CourseLectureAppointmentManager getCourseLectureAppointmentManager();
    CourseLectureManager getCourseLectureManager();
    CourseManager getCourseManager();
    CourseRegistrationManager getCourseRegistrationManager();
    FieldOfStudyManager getFieldOfStudyManager();
    MembershipRequestManager getMembershipRequestManager();
    StudentManager getStudentManager();
    TeamInvitationManager getTeamInvitationManager();
    TeamManager getTeamManager();
    TeamRegistrationManager getTeamRegistrationManager();
}
