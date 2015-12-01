package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
import net.unikit.database.interfaces.entities.Student;
import net.unikit.database.interfaces.entities.Team;
import net.unikit.database.exceptions.ConstraintViolationExceptionCommon;
import net.unikit.database.exceptions.ConstraintViolationException;
import net.unikit.database.exceptions.EntityNotFoundException;
import net.unikit.database.exceptions.ModelNotFoundExceptionCommon;
import net.unikit.database.internal.interfaces.entities.MembershipRequestModel;
import net.unikit.database.interfaces.entities.MembershipRequest;
import net.unikit.database.interfaces.managers.MembershipRequestManager;

import java.util.List;

/**
 * Created by Andreas on 26.11.2015.
 */
final class MembershipRequestManagerImpl implements MembershipRequestManager {
    private DatabaseManagerImpl databaseManager;

    private MembershipRequestManagerImpl(DatabaseManagerImpl databaseManager) {
        this.databaseManager = databaseManager;
    }

    static MembershipRequestManager create(DatabaseManagerImpl databaseManager) {
        return new MembershipRequestManagerImpl(databaseManager);
    }

    @Override
    public List<MembershipRequest> getAllEntities() {
        List<MembershipRequestModel> allEntities = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().getAllEntities();
        ImmutableList.Builder<MembershipRequest> builder = ImmutableList.builder();
        for (MembershipRequestModel entity : allEntities) {
            builder.add(MembershipRequestImpl.create(entity));
        }
        return builder.build();
    }

    @Override
    public MembershipRequest getEntity(MembershipRequest.ID id) throws EntityNotFoundException {
        try {
            MembershipRequestModel entity = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().getEntity(id.getValue());
            return MembershipRequestImpl.create(entity);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(id);
        }
    }

    @Override
    public void updateEntity(MembershipRequest entity) throws EntityNotFoundException, ConstraintViolationException {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().updateEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
    }

    @Override
    public void deleteEntity(MembershipRequest entity) throws EntityNotFoundException {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        try {
            databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().deleteEntity(model);
        } catch (ModelNotFoundExceptionCommon e) {
            throw new EntityNotFoundException(entity);
        }
    }

    @Override
    public MembershipRequest.ID addEntity(MembershipRequest entity) throws ConstraintViolationException {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        Integer id = null;
        try {
            id = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().addEntity(model);
        } catch (ConstraintViolationExceptionCommon e) {
            throw new ConstraintViolationException(e.getCause(), entity);
        }
        return new MembershipRequestImpl.IDImpl(id);
    }

    @Override
    public MembershipRequest createEntity() {
        MembershipRequestModel model = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().createEntity();
        return MembershipRequestImpl.create(model);
    }

    @Override
    public MembershipRequest.ID createID(Integer value) {
        return new MembershipRequestImpl.IDImpl(value);
    }

    @Override
    public MembershipRequest getMembershipRequest(Student requestingStudent, Team team) {
        MembershipRequest membershipRequest = null;

        for(MembershipRequest currentMembershipRequest : getAllEntities()){
            if(currentMembershipRequest.getApplicant().equals(requestingStudent) &&
                    currentMembershipRequest.getTeam().equals(team)){
                membershipRequest = currentMembershipRequest;
                break;
            }
        }
        return membershipRequest;
    }
}
