package net.unikit.database.implementations;

import com.google.common.collect.ImmutableList;
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
    public MembershipRequest getEntity(MembershipRequest.ID id) {
        MembershipRequestModel entity = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().getEntity(id.getValue());
        return MembershipRequestImpl.create(entity);
    }

    @Override
    public void updateEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().updateEntity(model);
    }

    @Override
    public void deleteEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().deleteEntity(model);
    }

    @Override
    public MembershipRequest.ID addEntity(MembershipRequest entity) {
        MembershipRequestModel model = ((MembershipRequestImpl)(entity)).model;
        Integer id = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().addEntity(model);
        return new MembershipRequestImpl.IDImpl(id);
    }

    @Override
    public MembershipRequest createEntity() {
        MembershipRequestModel model = databaseManager.getInternalDatabaseManager().getMembershipRequestModelManager().createEntity();
        return MembershipRequestImpl.create(model);
    }
}
